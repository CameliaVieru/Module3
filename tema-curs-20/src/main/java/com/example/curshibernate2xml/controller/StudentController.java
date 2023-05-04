package com.example.curshibernate2xml.controller;

import com.example.curshibernate2xml.model.Adresa;
import com.example.curshibernate2xml.model.Materie;
import com.example.curshibernate2xml.model.Student;
import com.example.curshibernate2xml.dtos.StudentSuccessResponseDTO;
import com.example.curshibernate2xml.repos.MaterieRepository;
import com.example.curshibernate2xml.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/st")
public class StudentController {
    private final StudentRepository studentRepository;
    private final MaterieRepository materieRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, MaterieRepository materieRepository) {
        this.studentRepository = studentRepository;
        this.materieRepository = materieRepository;
    }


    @GetMapping(path = "/student/all")
    public @ResponseBody
    ResponseEntity<List<Student>> getStudents(@RequestParam(name = "page", required = false) Integer page) {
        Iterable<Student> allStudents = studentRepository.findAll();

        List<Student> studentsList = StreamSupport.stream(allStudents.spliterator(), false)
                .collect(Collectors.toList());

        List<StudentSuccessResponseDTO> response = new ArrayList<>();
        for(Student student: allStudents) {
            response.add(new StudentSuccessResponseDTO(student.getId(), student.getNume(), student.getPrenume(), student.getCursuriAlese()));
        }

        return new ResponseEntity<>(studentsList, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/studentByNume")
    public @ResponseBody
    Optional<Student> getStudentByNumeAndPrenume(@RequestParam(name = "nume") String nume, @RequestParam(name = "prenume", required = false) String prenume) {
        if (prenume == null) {
            return studentRepository.findByNume(nume);
        }
        return studentRepository.findByNumeAndPrenume(nume, prenume);
    }

    @GetMapping(path = "/student/localitate")
    public @ResponseBody
    List<Optional<Student>> getStudentByNumeAndLocalitate(@RequestParam(name = "nume") String nume, @RequestParam(name = "localitate") String localitate) {
        return studentRepository.findByNumeAndLocalitate(nume, localitate);
    }

    @PostMapping("/student/enroll")
    public @ResponseBody String enroll(@RequestParam(name = "studentId") Integer studentId, @RequestParam(name = "materieId") Integer materieId){
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Materie> materie = materieRepository.findById(materieId);
        if(!student.isPresent() || !materie.isPresent()){
            return "Could not enroll student " + student.get().getNume() + " to course " + materie.get().getNume();
        }
        student.get().getCursuriAlese().add(materie.get());
        studentRepository.save(student.get());
        return "Enrolled";
    }

    @PostMapping("/student")
    public @ResponseBody Student addStudent(@RequestBody Student student){
        return  studentRepository.save(student);
    }

    @PutMapping("/student/{studentId}/adresa")
    public @ResponseBody Optional<Student> updateAdress(@PathVariable Integer studentId, @RequestBody Adresa address){
        Optional<Student> student = studentRepository.findById(studentId);
        if(!student.isPresent()){
            return Optional.empty();
        }
        student.get().setAdresa(address);
        studentRepository.save(student.get());
        return student;
    }

    @DeleteMapping("/student/{studentId}")
    public @ResponseBody String deleteStudent(@PathVariable Integer studentId){
        Optional<Student> student  = studentRepository.findById(studentId);
        if(!student.isPresent()){
            return "This student is not enrolled anywhere";
        }
        student.get().getInscrieri().clear();
        studentRepository.delete(student.get());
        return "The student " + student.get().getNume() + " " + student.get().getPrenume() + " with ID: " + studentId + " has been unenrolled from all courses";
    }

}

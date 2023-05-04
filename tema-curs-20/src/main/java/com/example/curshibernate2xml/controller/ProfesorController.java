package com.example.curshibernate2xml.controller;

import com.example.curshibernate2xml.model.Materie;
import com.example.curshibernate2xml.model.Profesor;
import com.example.curshibernate2xml.repos.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/pr")
public class ProfesorController {

    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorController(ProfesorRepository profesorRepository){
        this.profesorRepository = profesorRepository;
    }

    @GetMapping(path = "/profesor/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesor(@PathVariable Integer id){
        return ResponseEntity.ok(profesorRepository.findById(id));
    }

    @GetMapping(path = "/profesor/materii/{id}")
    public ResponseEntity<List<Optional<Materie>>> getMateriiByProfesor(@PathVariable Integer id){
        return ResponseEntity.ok(profesorRepository.getMateriiPredateByProf(id));
    }
}

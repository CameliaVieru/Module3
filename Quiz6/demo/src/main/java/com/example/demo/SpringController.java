package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    @GetMapping("/add/first/{first}/second/{second}")
    public ResponseEntity<Integer> handleGetSum(){
        Numbers nr = new Numbers("1", "3");
        int sum = Integer.parseInt(nr.getFirst()) + Integer.parseInt(nr.getSecond());
        return new ResponseEntity<>(sum, HttpStatus.OK);
        //idk m-am incurcat
    }

    public String getNumbers(@PathVariable String first, String second) {
        return first + "&" + second;
    }
}

class Numbers{
    String first;
    String second;

    public Numbers(String first, String second){
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}

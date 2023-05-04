package com.example.curshibernate2xml.dtos;

import com.example.curshibernate2xml.model.Materie;
import lombok.Data;

import java.util.Set;


@Data
public class StudentSuccessResponseDTO {
    private final Integer id;
    private final String nume;
    private final String prenume;
    private final Set<Materie> cursuriAlese;
}

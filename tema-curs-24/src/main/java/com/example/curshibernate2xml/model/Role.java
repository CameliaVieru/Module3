package com.example.curshibernate2xml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    USER("user"),
    ADMIN("admin");

    private final String role;
}

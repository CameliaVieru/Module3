package com.example.curshibernate2xml.repos;

import com.example.curshibernate2xml.model.Materie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Integer> {
}

package com.sarobidy.test.Employe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarobidy.test.Employe.entity.Sexe;

@Repository
public interface SexeRepository extends JpaRepository<Sexe, Long> {

}

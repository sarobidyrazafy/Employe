package com.sarobidy.test.Employe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sarobidy.test.Employe.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("SELECT e FROM Employe e WHERE e.nom = :nom AND e.sexe.id = :id")
    Optional<Employe> findEmployeByNomSexe(@Param("nom") String nom, @Param("id") Long id);
}

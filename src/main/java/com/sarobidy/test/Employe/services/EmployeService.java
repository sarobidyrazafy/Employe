package com.sarobidy.test.Employe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarobidy.test.Employe.entity.Employe;
import com.sarobidy.test.Employe.entity.Sexe;
import com.sarobidy.test.Employe.repository.EmployeRepository;
import com.sarobidy.test.Employe.repository.SexeRepository;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private SexeRepository sexeRepository;

    public List<Employe> allEmploye() {
        List<Employe> employes = employeRepository.findAll();
        return employes;
    }

    public Employe saveEmploye(String nom, Long id_sexe) {
        Sexe sexe = sexeRepository.findById(id_sexe).orElse(null);
        Employe emp = new Employe();
        emp.setNom(nom);
        emp.setSexe(sexe);
        return employeRepository.save(emp);
    }

    public void supprimerEmploye(Long id) {
        Employe emp = employeRepository.findById(id).orElse(null);
        if (emp != null) {
            employeRepository.delete(emp);
        }
    }

    public Employe employeById(Long id) {
        Employe emp = employeRepository.findById(id).orElse(null);
        return emp;
    }

    public Employe modifierEmploye(Long id, String nom, Long id_sexe) {
        Optional<Employe> optionalEmploye = employeRepository.findById(id);
        Sexe sexe = sexeRepository.findById(id_sexe).orElse(null);
        if (optionalEmploye.isPresent()) {
            if (sexe != null && optionalEmploye.isPresent()) {
                Employe employe = optionalEmploye.get();
                employe.setNom(nom);
                employe.setSexe(sexe);
                return employeRepository.save(employe);
            }
            return null;
        }
        return null;
    }
}

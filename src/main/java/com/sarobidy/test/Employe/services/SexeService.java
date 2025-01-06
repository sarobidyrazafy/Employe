package com.sarobidy.test.Employe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarobidy.test.Employe.entity.Sexe;
import com.sarobidy.test.Employe.repository.SexeRepository;

@Service
public class SexeService {
    @Autowired
    private SexeRepository sexeRepository;

    public List<Sexe> allSexe() {
        List<Sexe> sexes = sexeRepository.findAll();
        return sexes;
    }
}

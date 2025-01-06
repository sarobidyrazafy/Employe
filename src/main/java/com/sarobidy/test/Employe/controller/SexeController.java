package com.sarobidy.test.Employe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sarobidy.test.Employe.services.SexeService;

@Controller
public class SexeController {
    @Autowired
    private SexeService sexeService;
}

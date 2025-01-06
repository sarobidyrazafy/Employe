package com.sarobidy.test.Employe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarobidy.test.Employe.entity.Employe;
import com.sarobidy.test.Employe.entity.Sexe;
import com.sarobidy.test.Employe.services.EmployeService;
import com.sarobidy.test.Employe.services.SexeService;

@Controller
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private SexeService sexeService;

    @GetMapping("/liste")
    public String listeEmploye(Model model) {
        List<Employe> employes = employeService.allEmploye();
        model.addAttribute("employes", employes);
        return "liste-employe";
    }

    @GetMapping("/inserer")
    public String insererEmploye(Model model) {
        // Charger la liste des sexes pour le formulaire
        List<Sexe> sexes = sexeService.allSexe();
        model.addAttribute("sexes", sexes);
        return "inserer-employe";
    }

    @PostMapping("/traitement/inserer")
    public String traitementInsertionEmploye(
            Model model,
            @RequestParam("nom") String nom,
            @RequestParam("id_sexe") Long id_sexe) {

        String erreur = "";
        String reussite = "";

        Employe emp = employeService.saveEmploye(nom, id_sexe);
        if (emp != null) {
            reussite = "L'employé a été inséré avec succès.";
        } else {
            erreur = "Une erreur est survenue lors de l'insertion.";
        }

        // Ajouter les messages au modèle
        model.addAttribute("erreur", erreur);
        model.addAttribute("reussite", reussite);

        // Recharger la liste des sexes pour le formulaire
        List<Sexe> sexes = sexeService.allSexe();
        model.addAttribute("sexes", sexes);

        return "inserer-employe";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerEmploye(@PathVariable("id") Long id, Model model) {
        employeService.supprimerEmploye(id);
        String message = "Employé supprimé avec succès.";
        List<Employe> employes = employeService.allEmploye();
        model.addAttribute("employes", employes);
        model.addAttribute("message", message);
        return "liste-employe";
    }

    @GetMapping("/modifier/{id}")
    public String modifierEmploye(@PathVariable("id") Long id, Model model) {
        Employe emp = employeService.employeById(id);
        model.addAttribute("emp", emp);
        List<Sexe> sexes = sexeService.allSexe();
        model.addAttribute("sexes", sexes);
        return "modifier-employe";
    }

    @PostMapping("/traitement/modifier")
    public String traitementModifierEmploye(
            Model model,
            @RequestParam("id") Long id,
            @RequestParam("nom") String nom,
            @RequestParam("id_sexe") Long id_sexe) {

        String message = "";

        Employe emp = employeService.modifierEmploye(id, nom, id_sexe);
        if (emp != null) {
            message = "Les informations de l'employé modifié avec succès.";
        } else {
            message = "Une erreur est survenue lors de la modification.";
        }
        model.addAttribute("message", message);
        List<Employe> employes = employeService.allEmploye();
        model.addAttribute("employes", employes);
        return "liste-employe";
    }

}

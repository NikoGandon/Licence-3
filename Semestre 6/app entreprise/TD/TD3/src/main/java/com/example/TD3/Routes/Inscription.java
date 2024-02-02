package com.example.TD3.Routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class Inscription {
    @GetMapping("/inscription")
    public String getInscription() {
        return "formulaireInscription";
    }

    @PostMapping("/inscription")
    public String postInscription(@RequestBody String prenom, HttpServletRequest httpServletRequest) {
        
        HttpSession session = httpServletRequest.getSession();

        System.out.println("------------------");
        System.out.println(prenom);
        System.out.println("------------------");

        session.setAttribute("prenomUtilisateur", prenom);

        return "confirmation";
    }
}
package com.example.TD3.Routes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;

import org.springframework.ui.Model;


@Controller
@Component
public class Inscription extends HttpFilter implements HttpSessionAttributeListener{
    @GetMapping("/inscription")
    public String getInscription() {
        return "formulaireInscription";
    }

    @PostMapping("/inscription")
    @ResponseBody
    public String postInscription(@RequestBody String prenom, HttpServletRequest httpServletRequest) {
        
        HttpSession session = httpServletRequest.getSession();

        String prenomUtilisateur = prenom;

        System.out.println("------------------");
        System.out.println(prenomUtilisateur);
        System.out.println("------------------");

        session.setAttribute("prenomUtilisateur", prenomUtilisateur);

        return "confirmation " + prenomUtilisateur;
    }

    @Override
    protected void doFilter(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain chain) {
        return;
    }

}
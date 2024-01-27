package com.example.TD2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * devinette
 */

@Controller
public class devinette {

    @GetMapping("/devinette")
    public String getDevine(HttpServletRequest request) {

        int nombreAleatoire = (int) (Math.random() * 100);

        HttpSession session = request.getSession();
        session.setAttribute("nombreAleatoire", nombreAleatoire);

        return "devinette";
    }
}

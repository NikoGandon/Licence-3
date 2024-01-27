package com.example.TD3.Routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Inscription {
    @GetMapping("inscription")
    public String getInscription() {
        return "formulaireInscription";
    }
    
}
package com.AppEntreprise.TD5.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AppEntreprise.TD5.Modeles.ProprietaireModel;

@Controller
public class ProprietaireControler {
    @GetMapping("/formProprietaire")
    @ResponseBody
    public String getFormProprietaireString(@ModelAttribute("models") ProprietaireModel models) {
        return "formProprietaire";
    }
    
}

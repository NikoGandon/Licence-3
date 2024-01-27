package com.example.TD3.Routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {
    @GetMapping("/")
    @ResponseBody
    public String getMethodName(@RequestParam String param) {

        return "home";
    }
    
}

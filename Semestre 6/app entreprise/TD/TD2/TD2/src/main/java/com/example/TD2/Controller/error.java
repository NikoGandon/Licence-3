package com.example.TD2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class error  {
    @GetMapping("/error")
    @ResponseBody
    public String getError() {
        return "error";
    }
}

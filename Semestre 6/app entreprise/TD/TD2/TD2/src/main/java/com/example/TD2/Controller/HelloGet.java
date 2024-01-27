package com.example.TD2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloGet {
    @GetMapping("/hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloName(@RequestParam(name = "name", defaultValue = "Default") String name) {
        return "Hello " + name;
    }

    @GetMapping("/test")
    @ResponseBody
    public String getTest() {
        return "Hello ma boy";
    }
}

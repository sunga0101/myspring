package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/send")
    public String getForm(){
        return "send";
    }

    @PostMapping("/recieve")
    public String receive(@RequestParam("msg") String msg, @RequestParam("email") String email){
        System.out.println(msg);
        System.out.println(email);
        return "send";
    }
}

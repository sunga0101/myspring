package com.example.demo.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @GetMapping("/create-view")
    public String createView(){
        return "create";
    }

}

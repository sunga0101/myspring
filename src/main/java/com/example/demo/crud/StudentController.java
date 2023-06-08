package com.example.demo.crud;

import com.example.demo.crud.model.StudentDto;
import com.example.demo.crud.model.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    // StudentService 를 Controller 에서 사용
    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    // create하는 view를 보여준다
    @GetMapping("/create-view")
    public String createView(){
        return "create";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("email") String email)
    {
        System.out.println(name);
        System.out.println(email);
        StudentDto studentDto = studentService.createStudent(name,email);
        System.out.println(studentDto.toString());
        return "redirect:/home"; // POST/redirect/GET
        // (이중 제출 방지 :Post에 대한 응답으로 create-view에 Get 요청 )
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("studentList", studentService.readAllStudent());

        return "studentHome";
    }

}

package com.example.demo.crud;

import com.example.demo.crud.model.StudentDto;
import com.example.demo.crud.model.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    // StudentService 를 Controller 에서 사용
    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // StudentController



    // create하는 view를 보여준다

    @GetMapping("/create-view")
    public String createView() {
        return "create";
    }
    @PostMapping("/create")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("email") String email) {
        System.out.println(name);
        System.out.println(email);
        StudentDto studentDto = studentService.createStudent(name, email);
        System.out.println(studentDto.toString());
        return "redirect:/home"; // POST/redirect/GET
        // (이중 제출 방지 :Post에 대한 응답으로 create-view에 Get 요청 )
    }

    @GetMapping("/home")
    public String home(Model model) {
        // 임의의 3명 학생 넣어줌
        model.addAttribute("studentList", studentService.readAllStudent());

        return "studentHome";
    }

    @GetMapping("/{id}") // <----- 변경
    public String read(
            @PathVariable("id") Long id, // <---- @PathVariable로 url로 넘겨 받은 값을
            Model model                 // Long id로 받아서 쓸수 있다.
    ) {
        System.out.println(id);
        model.addAttribute(
                "student",
                studentService.readStudent(id)
        );

        return "read";
    }


    // TODO url 설정 / ("/{id}/edit") 또는 ("/{id}/update-view") / @GetMapping
    @GetMapping("/{id}/update-view")
    public String updateView(
            // TODO 아이디와 Model 받아오기 / Long id, Model model
            @PathVariable("id") Long id,
            Model model
    ){
        // TODO Model에 student 데이터 부여 / studentService.readStudent
        model.addAttribute(
                "student",
                studentService.readStudent(id)
        );

        // TODO update.html 돌려주기 / "update"
        return "update";
    }

    @PostMapping("/{id}/update")
    public String update(
            // TODO StudentController.readOne()를 참조
            @PathVariable("id") Long id,
            // TODO StudentController.create()를 참조
            @RequestParam("name") String name,
            @RequestParam("email") String email
    ) {
        // service 활용하기
        studentService.updateStudent(id, name, email);
        // 상세보기 페이지로 redirect
        return String.format("redirect:/%s", id);
    }

    //deleteView 메소드 만들기 - delete page로 이동하도록
    // GetMapping 을 사용하여
    // Long id는 어떻게?
    // studentDto를 가지고
    // return..
    @GetMapping("/{id}/delete-view")
    public String deleteView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.readStudent(id));
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ) {
        studentService.deleteStudent(id);
        // update 때는 데이터가 남아있지만
        // delete 는 돌아갈 상세보기가 없다
        // 그래서 홈으로 돌아간다.
        return "redirect:/home";
    }

}

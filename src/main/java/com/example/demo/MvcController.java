package com.example.demo;

import com.example.demo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller

public class MvcController {
    private int hitCount = 0;
    static int lottoNum;
    static List<Integer> lottoList; // 6개 숫자 들어있는 로또 리스트
    static List<List> lottoCnt = new ArrayList<>();

    @RequestMapping("/hits")
    public String hits(Model model) {
        // 더미 데이터 먼저 넣어서 어떻게 나오는지 확인해보자
        hitCount++;
        model.addAttribute("hits", hitCount); // 처음엔 0 데이터 넣어줌
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNum = (int) (((Math.random() * 100) % 45) + 1);
            if (!lottoList.contains(lottoNum))
                lottoList.add(lottoNum);
            else i--; // 카운트 미포함
        }
        lottoCnt.add(lottoList);
        model.addAttribute("lottoList", lottoList);

        return "lotto";
    }

    @RequestMapping("/history")
    public String history(Model model) {
        if (lottoCnt.isEmpty())
            model.addAttribute("isLottoList", false);
        else model.addAttribute("isLottoList", true);

        model.addAttribute("lottoCnt", lottoCnt);
        return "history";
    }

    @RequestMapping("/")
    public String home(Model model) { // 이 model은 view가 활용하기 위한 model
        model.addAttribute("message",
                "Hello, Thymeleaf!");

        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) { // 위 메소드와 달라진 건 문자열-> 객체뿐
        model.addAttribute("st",// "object"
                new Student("유재석", "jaeseok@abc.com"));
        return "student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute("isLoggedIn",
                false); // true); // 조건부 렌더링
        //  list.isEmpty() 로 만들수도 있음
        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");
        model.addAttribute("listOfStrings", listOfStrings);
        List<Student> studentList = Arrays.asList(
                new Student("Amy", "aaa@naver.com"),
                new Student("Becky", "bbb@naver.com"),
                new Student("Chris", "ccc@naver.com")
        );
        model.addAttribute("studentList", studentList);
        return "each";
    }
}

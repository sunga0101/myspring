package com.example.demo;

import com.example.demo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller

public class MvcController {

    private final LottoService lottoService; // final : 객체를 변화시키지 않겠다

    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    static List<List> lottoCnt = new ArrayList<>();

    @RequestMapping("/hits")
    public String hits(Model model) {
        int hitcount = lottoService.addHit(); // model-controller 분리

        model.addAttribute("hits", hitcount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
        List<Integer> lottoList = new ArrayList<>();
        // 6개 숫자 들어있는 로또 리스트
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int randomNum = random.nextInt(1, 46);
            if (!lottoList.contains(randomNum)) {
                lottoList.add(randomNum);
            } // range: 1~45
            else i--; // 중복 숫자 카운트 미포함
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
                false); // 조건부 렌더링
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

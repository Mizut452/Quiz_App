package Mizut452.quiz_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/quiz")
    public String quizHome() {
        return "quizStartPage";
    }

    @RequestMapping("/")
    public String quizHome2() {
        return "quizResult";
    }
}

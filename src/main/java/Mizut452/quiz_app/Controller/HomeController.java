package Mizut452.quiz_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/quiz")
    public String quizHome() {
        return "quizStartPage";
    }

    @RequestMapping("/quiz/question")
    public String quizQuestion() {
        return "quizQuestionPage";
    }

    @RequestMapping("/quiz/finish")
    public String quizResult() {
        return "quizResult";
    }

    @RequestMapping("/quiz/question/good")
    public String quizRight() {
        return "quizRightPage";
    }

    @RequestMapping("/quiz/question/bad")
    public String quizBad() {
        return "quizBadPage";
    }
}
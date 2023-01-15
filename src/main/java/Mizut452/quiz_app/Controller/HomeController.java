package Mizut452.quiz_app.Controller;

import Mizut452.quiz_app.Mapper.QuizMapper;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    QuizMapper quizMapper;
    List<Integer> listQuestionId = new ArrayList<>();


    @RequestMapping("/quiz")
    public String quizHome() {
        return "quizStartPage";
    }

    @RequestMapping("/quiz/question")
    public String quizQuestion(Model model) {
        Random random = new Random();
        int quizIdAll = quizMapper.selectQuizIdAll().size();
        //for文によって10個の乱数を生成する。
        for (int i = 0; i < 10; i++) {
            //1~10が乱数
            int randomInt = random.nextInt(quizIdAll) + 1;
            if (i == 0) {
                listQuestionId.add(randomInt);
                i++;
            } else {
                int count =0;
                for(int c : listQuestionId) {
                    if (c == randomInt) {
                        count++;
                    }
                }
                if (count == 0) {
                    listQuestionId.add(randomInt);
                    i++;
                } else {
                    System.out.println("www");
                }
            }
        }
        int randomInt = 0;
        for (int i = 0; i < listQuestionId.size(); i++) {
            randomInt = listQuestionId.get(i);
        }
        model.addAttribute("Question", quizMapper.selectQuestionAll(randomInt));
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

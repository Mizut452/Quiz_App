package Mizut452.quiz_app.Controller;

import Mizut452.quiz_app.Mapper.QuizMapper;
import Mizut452.quiz_app.Model.Quiz;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    QuizMapper quizMapper;
    Quiz quiz;
    List<Integer> listQuestionId = new ArrayList<>();
    int questionLength = 0;
    int j = 0;
    int quizId = 0;


    @RequestMapping("/quiz")
    public String quizHome() {
        return "quizStartPage";
    }

    @RequestMapping("/quiz/question")
    public String quizQuestionPrepare(Model model) {
        //出題する問題を選ぶ（questionIdを生成する）
        int questionNumber = 0;
        Random random = new Random();
        questionLength = 10;
        int quizIdAll = quizMapper.selectQuizIdAll().size();
        //for文によってquestionLength個の乱数を生成する。
        for (int i = 0; i < questionLength; i++) {
            //1~10が乱数
            int randomInt = random.nextInt(quizIdAll) + 1;
            if (i == 0) {
                listQuestionId.add(randomInt);
                i++;
            } else {
                int count = 0;
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
        model.addAttribute("QuestionNumber", questionNumber);
        model.addAttribute("Question");
        model.addAttribute("Question", quizMapper.selectQuestionAll(randomInt));
        return "quizQuestionPage";
    }

    @RequestMapping("/quiz/question/{quizId}")
    public String quizQuestion(@PathVariable int quizId,
                               Model model) {
            quizId = listQuestionId.get(j);
            List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);

            Quiz quizList = quizAllByQuizId.get(j);
            String quizSentence = quizList.getQuizQuestionSent();


            model.addAttribute("QuestionNumber", j + 1);
            model.addAttribute("QuestionSentence", quizSentence);

        return "quizQuestionPage";
    }

    @RequestMapping("/quiz/question/{quizId}/judge")
    public String quizJudge() {
        quizId = listQuestionId.get(j);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(quizId);
        int rightOrBad = quizList.getQuizRightOrBad();
        quiz.setQuizUsersAnswer(quiz.getQuizUsersAnswer());
        if (quiz.getQuizRightOrBad() == rightOrBad) {
            j++;
            return "quizRightPage";
        }
        else {
            j++;
            return "quizBadPage";
        }
    }

    @RequestMapping("/quiz/finish")
    public String quizResult() {
        return "quizResult";
    }

    @RequestMapping("/quiz/question/good")
    public String quizRight(Model model) {

        model.addAttribute("QuestionCommentary", j);
        j++;
        return "quizRightPage";
    }

    @RequestMapping("/quiz/question/bad")
    public String quizBad(Model model) {

        model.addAttribute("QuestionCommentary", j);
        j++;
        return "quizBadPage";
    }
}

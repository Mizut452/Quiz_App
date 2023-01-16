package Mizut452.quiz_app.Controller;

import Mizut452.quiz_app.Mapper.QuizMapper;
import Mizut452.quiz_app.Model.Quiz;
import Mizut452.quiz_app.Model.QuizUsersAnswer;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    QuizMapper quizMapper;
    Quiz quiz;
    List<Integer> listQuestionId = new ArrayList<>();
    int questionLength = 0;
    int questionNumber = 0;
    int quizId = 0;


    @RequestMapping("/quiz")
    public String quizHome() {
        return "quizStartPage";
    }

    @RequestMapping("/quiz/question")
    public String quizQuestionPrepare(Model model) {
        //出題する問題を選ぶ（questionIdを生成する）
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
        quizId = listQuestionId.get(questionNumber);
        System.out.println(quizId+"/quiz/question");
        return "redirect:/quiz/question/" + quizId;
    }

    @RequestMapping("/quiz/question/{quizId}")
    public String quizQuestion(@PathVariable int quizId,
                               Model model) {
            List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);

            Quiz quizList = quizAllByQuizId.get(questionNumber);
            String quizSentence = quizList.getQuizQuestionSent();


            model.addAttribute("QuestionNumber", questionNumber + 1);
            model.addAttribute("QuestionSentence", quizSentence);
            model.addAttribute("quizId", quizId);

        return "quizQuestionPage";
    }

    @RequestMapping("/quiz/question/{quizId}/judge/")
    public String quizJudge(Model model) {
        //クイズの〇、×の確認
        //quizId = listQuestionId.get(questionNumber);
        System.out.println(quizId);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(questionNumber);
        int questionAnswer = quizList.getQuizRightOrBad();
        //送信された〇、×の確認
        QuizUsersAnswer quizTrueOrBad = new QuizUsersAnswer();
        quizTrueOrBad.setRightOrBad(quizTrueOrBad.getRightOrBad());
        int rightOrBad = quizTrueOrBad.getRightOrBad();

        questionNumber++;
        model.addAttribute("quizId", quizId);
        if (questionAnswer == rightOrBad) {
            return "quizRightPage";
        }
        else {
            return "quizBadPage";
        }
    }

    @RequestMapping("/quiz/finish")
    public String quizResult() {

        return "quizResult";
    }

    @RequestMapping("/quiz/question/good")
    public String quizRight(Model model) {
        quizId = listQuestionId.get(questionNumber);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(questionNumber);
        String quizCommentary = quizList.getQuizCommentary();


        model.addAttribute("QuestionCommentary", quizCommentary);

        return "redirect:/quiz/question/" + quizId;
    }

    @RequestMapping("/quiz/question/bad")
    public String quizBad(Model model) {
        quizId = listQuestionId.get(questionNumber);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(questionNumber);
        String quizCommentary = quizList.getQuizCommentary();
        model.addAttribute("QuestionCommentary", quizCommentary);

        return "redirect:/quiz/question/" + quizId;
    }
}

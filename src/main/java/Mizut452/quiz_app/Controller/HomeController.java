package Mizut452.quiz_app.Controller;

import Mizut452.quiz_app.Mapper.QuizMapper;
import Mizut452.quiz_app.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    @Autowired
    QuizMapper quizMapper;

    private List<Integer> listQuestionId = new ArrayList<>();
    private int questionLength = 0;
    private int questionNumber = 0;
    private int quizId = 0;
    private int userPoint = 0;


    @RequestMapping("/quiz")
    public String quizHome() {
        return "quiz/quizStartPage";
    }

    @GetMapping("/quiz/question")
    public String quizQuestionPrepare(Model model) {
        //初期化
        listQuestionId = new ArrayList<>();
        questionNumber = 0;
        quizId = 0;
        //出題する問題を選ぶ（questionIdを生成する）
        Random random = new Random();
        questionLength = 10;
        int quizIdAll = quizMapper.selectQuizIdAll().size();
        //for文によってquestionLength個の乱数を生成する。
        for (int i = 0; i < questionLength;) {
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
        for (int i = 0; i < listQuestionId.size(); i++) {
            System.out.println(listQuestionId.get(i) + "うんち！");
        }
        quizId = listQuestionId.get(questionNumber);
        System.out.println(quizId+"/quiz/question");
        return "redirect:/quiz/question/" + quizId + "/";
    }

    @GetMapping("/quiz/question/{quizId}/")
    public String quizQuestion(@PathVariable int quizId,
                               Model model) {
            List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
            Quiz quizList = quizAllByQuizId.get(0);
            String quizSentence = quizList.getQuizQuestionSent();
            System.out.println(quizId +"= {quizId}");

        if (questionNumber + 1 == questionLength) {
            model.addAttribute("QuestionNumber", questionNumber + 1);
            model.addAttribute("userPoint", userPoint + 1);
            return "quiz/quizResult";
        }



            model.addAttribute("QuestionNumber", questionNumber + 1);
            model.addAttribute("QuestionSentence", quizSentence);
            model.addAttribute("quizId", quizId);

        return "quiz/quizQuestionPage";

    }

    @PutMapping("/quiz/question/{quizId}/judge/")
    public String quizJudge(Model model,
                            @PathVariable int quizId,
                            @ModelAttribute Quiz quiz) {
        //クイズの〇、×の確認
        //quizId = listQuestionId.get(questionNumber);
        System.out.println(quizId + "と" +questionNumber +"judge");
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        for (int i = 0; i < quizAllByQuizId.size(); i++) {
            System.out.println(quizAllByQuizId.get(i)+"this is quiz/question/quizid/judge");
        }
        Quiz quizList = quizAllByQuizId.get(0);
        int questionAnswer = quizList.getQuizRightOrBad();
        System.out.println(questionAnswer + "questionAnswerだよ");

        //クイズの解説文の取り出し
        String questionCommentary = quizList.getQuizCommentary();
        model.addAttribute("QuestionCommentary", questionCommentary);

        //送信された〇、×の確認
        quiz.setQuizUsersAnswer(quiz.getQuizUsersAnswer());
        quizList.setQuizUsersAnswer(quizList.getQuizUsersAnswer());
        int rightOrBad = quiz.getQuizUsersAnswer();
        System.out.println("this is rightOrBad" + rightOrBad + "と, this is getRightOrBad");

        questionNumber++;
        int nextQuizId = listQuestionId.get(questionNumber);
        model.addAttribute("quizId", quizId);
        model.addAttribute("nextQuizId", nextQuizId);
        if (questionAnswer == rightOrBad) {
            userPoint++;
            return "quiz/quizRightPage";
        }
        else {
            return "quiz/quizBadPage";
        }
    }

    @GetMapping("/quiz/question/{quizId}/{answer}")
    public String sendQuizAnswer(@PathVariable int quizId, String answer) {

        return "redirect:/quiz/question/" + quizId + "/judge/";
    }

    @GetMapping("/quiz/question/good")
    public String quizRight(Model model) {
        quizId = listQuestionId.get(questionNumber);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(questionNumber);
        String quizCommentary = quizList.getQuizCommentary();


        model.addAttribute("QuestionCommentary", quizCommentary);

        return "redirect:/quiz/question/" + quizId;
    }

    @GetMapping("/quiz/question/bad")
    public String quizBad(Model model) {
        quizId = listQuestionId.get(questionNumber);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(questionNumber);
        String quizCommentary = quizList.getQuizCommentary();
        model.addAttribute("QuestionCommentary", quizCommentary);

        return "redirect:/quiz/question/" + quizId;
    }
}

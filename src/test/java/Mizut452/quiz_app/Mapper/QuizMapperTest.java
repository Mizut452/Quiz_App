package Mizut452.quiz_app.Mapper;

import Mizut452.quiz_app.Model.Quiz;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuizMapperTest {
    @Autowired
    QuizMapper quizMapper;

    @Test
    void doSelectQuizAll() {
        List<Quiz> quizAll = quizMapper.selectQuizIdAll();
        Quiz quizList = quizAll.get(0);
        int quizIdTest =quizList.getQuizId();
        assertEquals(1, quizIdTest);
    }
}

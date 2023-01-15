package Mizut452.quiz_app.Controller;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeControllerTest {
    List<Integer> listQuestionId = new ArrayList<>();

    //
    @Test
    void generateRandomInt() {
        //出題する問題を選ぶ（questionIdを生成する）
        //疑似乱数リスト
        List<Integer> randomIntList = Arrays.asList(1, 29, 4, 5, 1, 6, 16, 8, 8, 10, 18, 29, 2, 18, 16);
        int questionLength = 10;
        //for文によってquestionLength個の乱数を生成する。
        for (int i = 0; i < questionLength;) {
            int randomInt = randomIntList.get(i);
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
                    i++;
                }
            }
        }
        //乱数の取り出し
        int randomInt = 0;
        for (int i = 0; i < listQuestionId.size(); i++) {
            randomInt = listQuestionId.get(i);
            System.out.println(randomInt);
        }
        //randomInt = listQuestionId.get(i);
        assertEquals(29, listQuestionId.get(1));
        assertEquals(16, listQuestionId.get(5));
        assertEquals(10, listQuestionId.get(7));
        //(1, 29, 4, 5, 1, 6, 16, 8, 8, 10, 18, 29, 2, 18, 16)
        //(1, 29, 4, 5, 6, 16, 8, 10, 18, 2)
    }
}

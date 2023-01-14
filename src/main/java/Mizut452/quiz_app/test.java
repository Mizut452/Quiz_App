package Mizut452.quiz_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class test {
    List<Integer> putQuestionId = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> listQuestionId = new ArrayList<>();
        //ここで示した数の数字がランダムに出力される
        int listLength = 10;
        for(int i = 0; i < 10;) {
            //1~10が乱数
            int randomInt = random.nextInt(listLength) +1;
            if (i == 0) {
                listQuestionId.add(randomInt);
                i++;
            }

            if(i > 0) {
                int prev = listQuestionId.get(i -1);

                if (prev == randomInt) {
                    System.out.println("数字が被りました");
                } else {
                    listQuestionId.add(randomInt);
                    i++;
                }
            }
        }
        System.out.println(listQuestionId.get(0));
        System.out.println(listQuestionId.get(1));
        System.out.println(listQuestionId.get(2));
        System.out.println(listQuestionId.get(3));
        System.out.println(listQuestionId.get(4));
        System.out.println(listQuestionId.get(5));

    }
}

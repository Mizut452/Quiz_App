package Mizut452.quiz_app;

import java.util.*;

public class test {
    List<Integer> putQuestionId = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> listQuestionId = new ArrayList<>();
        int num = 0;
        //ここで示した数の数字がランダムに出力される
        int listLength = 10;
        for (int i = 0; i < 10; ) {
            //1~10が乱数
            int randomInt = random.nextInt(listLength) + 1;
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
        System.out.println(listQuestionId.size());
        System.out.println(listQuestionId.get(0));
        System.out.println(listQuestionId.get(1));
        System.out.println(listQuestionId.get(2));
        System.out.println(listQuestionId.get(3));
        System.out.println(listQuestionId.get(4));
        System.out.println(listQuestionId.get(5));
    }
}


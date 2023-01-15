package Mizut452.quiz_app;

import java.util.*;

public class test {
    List<Integer> putQuestionId = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> listQuestionId = new ArrayList<>();
        int num = 0;
        //ここで示した数の数字がランダムに出力される
        /*int listLength = 10;
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
        */

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
    }
}


package Mizut452.quiz_app.Model;

import lombok.Data;

@Data
public class Quiz {
    private int quizId;
    private String quizQuestionSent;
    private boolean quizRightOrBad;
    private String quizCommentary;
}

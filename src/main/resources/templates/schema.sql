DROP TABLE IF EXISTS quiz;

CREATE TABLE IF NOT EXISTS quiz (
        quizId INTEGER PRIMARY KEY AUTO_INCREMENT,
        quizQuestionSent VARCHAR(255) NOT NULL,
        quizRightOrBad boolean NOT NULL,
        quizCommentary VARCHAR(255) NOT NULL
);
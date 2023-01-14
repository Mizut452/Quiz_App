package Mizut452.quiz_app.Mapper;

import Mizut452.quiz_app.Model.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface quizMapper {

    @Select("SELECT * FROM quiz")
    List<Quiz> selectAll();
}
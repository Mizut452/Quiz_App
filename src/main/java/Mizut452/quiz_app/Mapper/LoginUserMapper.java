package Mizut452.quiz_app.Mapper;

import Mizut452.quiz_app.Model.LoginUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginUserMapper {
    @Select("SELECT * FROM userList")
    List<LoginUser> selectAll();

    @Select("SELECT * FROM userList WHERE username = #{username}")
    LoginUser findByUsername(@Param("username") String username);

    @Insert("INSERT INTO userList(email, username, password, roleList) VALUES(#{email}, #{username}, #{password}, 2)")
    void create(LoginUser loginUser);
}

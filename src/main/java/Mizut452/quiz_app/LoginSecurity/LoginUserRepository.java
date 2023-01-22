package Mizut452.quiz_app.LoginSecurity;

import Mizut452.quiz_app.Mapper.LoginUserMapper;
import Mizut452.quiz_app.Model.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginUserRepository {
    private final LoginUserMapper loginUserMapper;

    public List<LoginUser> selectAll() {
        return loginUserMapper.selectAll();
    }

    public LoginUser findByUsername(String username) {
        return loginUserMapper.findByUsername(username);
    }
}

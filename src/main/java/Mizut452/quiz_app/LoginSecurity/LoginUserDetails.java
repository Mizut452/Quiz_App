package Mizut452.quiz_app.LoginSecurity;

import Mizut452.quiz_app.Model.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class LoginUserDetails{
    private LoginUser loginUser;

    public LoginUser getLoginUser() {
        return loginUser;
    }
}

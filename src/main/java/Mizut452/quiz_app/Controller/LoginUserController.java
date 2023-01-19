package Mizut452.quiz_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginUserController {
    @RequestMapping("/createaccount")
    public String createAccount() {
        return "loginUser/createAccount";
    }
}

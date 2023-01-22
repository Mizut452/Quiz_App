package Mizut452.quiz_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginUserController {
    @RequestMapping("/createaccount")
    public String createAccount() {
        return "loginUser/createAccount";
    }

    @PostMapping("/create")
    public String createMethod() {

        return "redirect:/create/roles";
    }

    @PostMapping("/create/roles")
    public String createRoles() {

        return "createComplete";
    }
}

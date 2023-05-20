package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.model.User;
import web.service.UserServiceEntity;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 19.05.2023 15:52 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class LoginSignupController {

    private final UserServiceEntity userService;

    @GetMapping("/signup")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(User user) {
        userService.saveUser(user);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String confirmUser(User user, RedirectAttributes redirectAttributes) {
        if (userService.existsUserByEmailAndPassword(user.getEmail(), user.getPassword()))
            return "redirect:/users/" +
                    userService.getUserByEmail(user.getEmail()).getId() +
                    "/posts";
        else {
            redirectAttributes.addFlashAttribute("error", "Неправильно введены логин или пароль!");
            return "redirect:/login";
        }
    }
}

package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserServiceEntity;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:29 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private static final String REDIRECT = "redirect:/users";
    private final UserServiceEntity userService;

    /**
     * Все пользователи
     */
    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users";
    }

    /**
     * Добавление пользователя
     */
    @GetMapping("/add")
    public String addUser() {
        return "userAdd";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return REDIRECT;
    }

    /**
     * Изменение пользователя
     *
     * @param id идентификатор пользователя
     */
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userUpdate";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return REDIRECT;
    }

    /**
     * Удаление пользователя
     *
     * @param id идентификатор пользователя
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return REDIRECT;
    }
}

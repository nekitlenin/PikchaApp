package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

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
    private final UserService userRepository;

    /**
     * Все пользователи
     */
    @GetMapping
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("users");
        modelAndView.addObject("userList", userRepository.listAll());
        return modelAndView;
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
        userRepository.save(user);
        return REDIRECT;
    }

    /**
     * Изменение пользователя
     *
     * @param id идентификатор пользователя
     */
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.get(id));
        return "userUpdate";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userRepository.save(user);
        return REDIRECT;
    }

    /**
     * Удаление пользователя
     *
     * @param id идентификатор пользователя
     */
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return REDIRECT;
    }
}

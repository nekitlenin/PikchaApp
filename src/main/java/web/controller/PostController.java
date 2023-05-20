package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Post;
import web.model.User;
import web.service.PostServiceEntity;
import web.service.UserServiceEntity;

import java.util.List;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.05.2023 00:47 |
 * Created with IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/posts")
public class PostController {

    private final PostServiceEntity postService;
    private final UserServiceEntity userService;

    /**
     * Все посты пользователя
     * @param userId идентификатор пользователя
     */
    @GetMapping()
    public String postsOfUser(@PathVariable("userId") Long userId, Model model) {
        User user = userService.getUserById(userId);
        List<Post> posts = postService.findByUserId(userId);

        model.addAttribute("user", user);
        model.addAttribute("postList", posts);
        return "posts";
    }

    /**
     * Добавление поста пользователю
     * @param userId идентификатор пользователя
     */
    @GetMapping("/add")
    public String addPost(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "postAdd";
    }

    @PostMapping("/add")
    public String addPost(@PathVariable("userId") Long userId, Model model, Post post) {
        post.setUser(userService.getUserById(userId));
        postService.savePost(post);
//        model.addAttribute("userList", userService.findAll());
        return "redirect:/users/" + userId + "/posts";
    }

    /**
     * Изменение поста у пользователя
     * @param userId идентификатор пользователя
     * @param postId идентификатор поста
     */
    @GetMapping("/{postId}/update")
    public String updatePost(@PathVariable("userId") Long userId,
                                @PathVariable("postId") Long postId, Model model) {
        model.addAttribute("post", postService.getPostById(postId));
        model.addAttribute("userId", userId);
        return "postUpdate";
    }

    @PostMapping("/{postId}/update")
    public String updatePost(@PathVariable("userId") Long userId, @PathVariable Long postId, Post post) {
        post.setUser(userService.getUserById(userId));
        postService.savePost(post);
        return "redirect:/users/" + userId + "/posts";
    }

    /**
     * Удаление поста у пользователя
     * @param userId идентификатор пользователя
     * @param postId идентификатор поста
     */
    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId) {
        postService.deleteById(postId);
        return "redirect:/users/" + userId + "/posts";
    }
}

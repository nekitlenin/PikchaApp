package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Post;
import web.service.PostServiceEntity;
import web.service.UserServiceEntity;

import java.time.LocalDate;

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
     * Все посты пользователя + пагинация + сортировка постов: none, по дате, по заголовку
     *
     * @param userId идентификатор пользователя
     */
    @GetMapping()
    public String allPostsOfUser(@PathVariable("userId") Long userId,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "default") String sortType,
                                 Model model) {
        Page<Post> result;

        if (!isCorrect(pageSize, page))
            model.addAttribute("error", "Страница должна быть >= 0, а размер страницы должен быть > 0");
        if (pageSize <= -1 || page <= -1)
            result = postService.getPostsByUserId(userId, Pageable.unpaged());
        else
            result = getResult(userId, page, pageSize, sortType);
        addAttributes(model, userId, pageSize, page, sortType, result);
        return "posts";
    }

    private boolean isCorrect(int pageSize, int page) {
        return pageSize != 0 && pageSize >= -1 && page >= -1;
    }

    private Page<Post> getResult(Long userId, int page, int pageSize, String sortType) {
        if (sortType.equals("date"))
            return postService.getPostsByUserId(userId, PageRequest.of(
                    page, pageSize, Sort.by("dateCreate").ascending()));
        else if (sortType.equals("title"))
            return postService.getPostsByUserId(userId, PageRequest.of(
                    page, pageSize, Sort.by("title").ascending()));
        else
            return postService.getPostsByUserId(userId, PageRequest.of(page, pageSize));
    }

    private void addAttributes(Model model, Long userId, int pageSize,
                               int page, String sortType, Page<Post> result) {
        model.addAttribute("user", userService.getUserById(userId));

        model.addAttribute("page", pageSize);
        model.addAttribute("pageSize", page);
        model.addAttribute("sortType", sortType);

        model.addAttribute("postList", result.getContent());
        model.addAttribute("totalPosts", result.getTotalElements());
        model.addAttribute("totalPages", result.getTotalPages());
    }

    /**
     * Добавление поста пользователю
     *
     * @param userId идентификатор пользователя
     */
    @GetMapping("/add")
    public String addPost(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "postAdd";
    }

    @PostMapping("/add")
    public String addPost(@PathVariable("userId") Long userId, Post post) {
        post.setUser(userService.getUserById(userId));
        post.setDateCreate(LocalDate.now());
        postService.savePost(post);
        return "redirect:/users/" + userId + "/posts";
    }

    /**
     * Изменение поста у пользователя
     *
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
        post.setDateCreate(LocalDate.now());
        postService.savePost(post);
        return "redirect:/users/" + userId + "/posts";
    }

    /**
     * Удаление поста у пользователя
     *
     * @param userId идентификатор пользователя
     * @param postId идентификатор поста
     */
    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId) {
        postService.deleteById(postId);
        return "redirect:/users/" + userId + "/posts";
    }
}

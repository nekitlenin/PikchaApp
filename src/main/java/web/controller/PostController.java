package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
@RequestMapping("/posts/{userId}")
public class PostController {

    private final PostServiceEntity postRepository;
    private final UserServiceEntity userService;

    /**
     * Все посты пользователя + пагинация + сортировка постов: none, по дате, по заголовку
     *
     * @param userId идентификатор пользователя
     */
    @GetMapping()
    public ModelAndView allPostsOfUser(@PathVariable("userId") Long userId,
                                       @RequestParam(defaultValue = "10") int pageSize,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "default") String sortType) {
        Page<Post> result;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("posts");

        if (!isCorrect(pageSize, page))
            modelAndView.addObject("error", "Страница должна быть >= 0, а размер страницы должен быть > 0");
        if (pageSize <= -1 || page <= -1)
            result = postRepository.getPostsByUserId(userId, Pageable.unpaged());
        else
            result = getResult(userId, page, pageSize, sortType);
        return addAttributes(modelAndView, userId, pageSize, page, sortType, result);
    }

    private boolean isCorrect(int pageSize, int page) {
        return pageSize != 0 && pageSize >= -1 && page >= -1;
    }

    private Page<Post> getResult(Long userId, int page, int pageSize, String sortType) {
        if (sortType.equals("date"))
            return postRepository.getPostsByUserId(userId, PageRequest.of(
                    page, pageSize, Sort.by("dateCreate").ascending()));
        else if (sortType.equals("title"))
            return postRepository.getPostsByUserId(userId, PageRequest.of(
                    page, pageSize, Sort.by("title").ascending()));
        else
            return postRepository.getPostsByUserId(userId, PageRequest.of(page, pageSize));
    }

    private ModelAndView addAttributes(ModelAndView model, Long userId, int pageSize,
                               int page, String sortType, Page<Post> result) {
        model.addObject("user", userService.get(userId));
        model.addObject("page", pageSize);
        model.addObject("pageSize", page);
        model.addObject("sortType", sortType);
        model.addObject("postList", result.getContent());
        model.addObject("totalPosts", result.getTotalElements());
        model.addObject("totalPages", result.getTotalPages());
        return model;
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
        post.setUser(userService.get(userId));
        post.setDateCreate(LocalDate.now());
        postRepository.save(post);
        return "redirect:/posts/" + userId;
    }

    /**
     * Изменение поста у пользователя
     *
     * @param userId идентификатор пользователя
     * @param postId идентификатор поста
     */
    @GetMapping("/update/{postId}")
    public String updatePost(@PathVariable("userId") Long userId,
                             @PathVariable("postId") Long postId, Model model) {
        model.addAttribute("post", postRepository.getPostById(postId));
        model.addAttribute("userId", userId);
        return "postUpdate";
    }

    @PostMapping("/update/{postId}")
    public String updatePost(@PathVariable("userId") Long userId, @PathVariable Long postId, Post post) {
        post.setUser(userService.get(userId));
        post.setDateCreate(LocalDate.now());
        postRepository.save(post);
        return "redirect:/posts/" + userId;
    }

    /**
     * Удаление поста у пользователя
     *
     * @param userId идентификатор пользователя
     * @param postId идентификатор поста
     */
    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable("userId") Long userId, @PathVariable("postId") Long postId) {
        postRepository.deleteById(postId);
        return "redirect:/posts/" + userId;
    }
}

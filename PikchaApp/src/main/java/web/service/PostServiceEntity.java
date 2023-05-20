package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.repository.PostRepository;

import java.util.List;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:33 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceEntity {

    private final PostRepository repository;

    public Post getPostById(Long id) {
        return repository.getPostById(id);
    }

    public void savePost(Post post) {
        repository.save(post);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Post> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
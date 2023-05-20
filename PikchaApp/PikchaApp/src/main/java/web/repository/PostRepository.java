package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import web.model.Post;

import java.util.List;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:22 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Post getPostById(Long id);

    @NonNull
    Post save(@NonNull Post post);

    void deleteById(@NonNull Long id);

    List<Post> findByUserId(Long userId);
}

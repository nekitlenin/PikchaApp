package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 00:28 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @NonNull
    List<User> findAll();

    User getUserById(Long id);

    @NonNull
    User save(@NonNull User user);

    void deleteById(@NonNull Long id);

    User getUserByEmail(String email);

    boolean existsUserByEmailAndPassword(String email, String password);
}

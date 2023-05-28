package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

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

    User findByEmail(String email);
}

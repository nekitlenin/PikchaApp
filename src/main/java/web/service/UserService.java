package web.service;

import web.model.User;

import java.util.List;

/**
 * Project: PikchaApp
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 27.05.2023 20:50 |
 * Created with IntelliJ IDEA
 */
public interface UserService {

    void save(User user);

    List<User> listAll();

    User get(long id);

    void delete(long id);

    User findByEmail(String email);
}

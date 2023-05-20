package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:36 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    public boolean existsUserByEmailAndPassword(String email, String password) {
        return repository.existsUserByEmailAndPassword(email, password);
    }
}

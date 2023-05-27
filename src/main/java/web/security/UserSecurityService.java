package web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

/**
 * Project: PikchaApp
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 27.05.2023 06:35 |
 * Created with IntelliJ IDEA
 */
@Service
public class UserSecurityService {

    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @PreAuthorize("@userSecurityService.isPostOwner(#userId, authentication)")
    public boolean isPostOwner(Long userId, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getDetails();
        UserDetails userDet = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String username2 = userDet.getUsername();
        System.out.println("****************************");
        System.out.println(username);
        System.out.println(username2);
        System.out.println(userId);
        System.out.println("****************************");

//        if (username == null) {
//            throw new IllegalArgumentException();
//        }

        User user = userRepository.findByEmail(username);


        return user.getId().equals(userId);
    }
}

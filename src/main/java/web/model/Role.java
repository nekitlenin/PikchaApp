package web.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Project: PikchaApp
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 26.05.2023 02:58 |
 * Created with IntelliJ IDEA
 */
@Entity
@Table(name = "roles")
@AllArgsConstructor
@RequiredArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}

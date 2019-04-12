package application.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String password;
    private String email;
//            cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    ,joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role")
    private Set<Role> roles;

}

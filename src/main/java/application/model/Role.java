package application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue
    private Integer role_id;
    private String role;




}

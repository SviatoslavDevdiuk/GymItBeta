package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RegistrationAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String registrationKey;
}

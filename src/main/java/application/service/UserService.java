package application.service;

import application.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUserName(String userName);
}

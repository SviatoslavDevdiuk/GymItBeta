package Application.service;

import Application.dao.UserRepository;
import Application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        CustomUserDetails userDetails = null;
        if (user != null) {
             userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        } else throw new UsernameNotFoundException("User with name " + userName + " does not exists!");
        return userDetails;
    }
}

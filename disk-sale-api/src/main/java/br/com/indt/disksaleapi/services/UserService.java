package br.com.indt.disksaleapi.services;

import br.com.indt.disksaleapi.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    User findUserByLogin(String login);

    void saveUser(User user);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}

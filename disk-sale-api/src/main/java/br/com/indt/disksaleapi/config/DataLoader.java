package br.com.indt.disksaleapi.config;

import br.com.indt.disksaleapi.model.Role;
import br.com.indt.disksaleapi.model.User;
import br.com.indt.disksaleapi.repositories.RoleRepository;
import br.com.indt.disksaleapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository,
                      @Qualifier("getEncoder") PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        loadRoles();
        loadUsers();
    }

    private void loadRoles() {
        Role admin = new Role();
        admin.setRole("ADMIN");

        Role user = new Role();
        user.setRole("USER");

        roleRepository.save(admin);
        roleRepository.save(user);
    }

    private void loadUsers() {
        User admin = new User();
        admin.setFullName("Admin");
        admin.setPassword("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setLogin("admin");

        Role userRole = roleRepository.findByRole("ADMIN");
        admin.setRoles(new HashSet<>(Arrays.asList(userRole)));

        userRepository.save(admin);
    }
}
package br.com.indt.disksaleapi.config;

import br.com.indt.disksaleapi.model.Disk;
import br.com.indt.disksaleapi.model.Role;
import br.com.indt.disksaleapi.model.Sale;
import br.com.indt.disksaleapi.model.User;
import br.com.indt.disksaleapi.repositories.RoleRepository;
import br.com.indt.disksaleapi.repositories.SaleRepository;
import br.com.indt.disksaleapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private SaleRepository saleRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository,
                      @Qualifier("getEncoder") PasswordEncoder passwordEncoder,
                      SaleRepository saleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.saleRepository = saleRepository;

        loadRoles();
        loadUsers();
        loadSales();
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

    private void loadSales() {
        Disk disk1 = new Disk();
        disk1.setPrice(new BigDecimal("123.45"));
        disk1.setName("Test1");

        Disk disk2 = new Disk();
        disk2.setPrice(new BigDecimal("50.45"));
        disk2.setName("Test2");

        Sale sale = new Sale();
        sale.setDisk(disk1);
        sale.setQuantity(10);

        Sale sale2 = new Sale();
        sale2.setDisk(disk2);
        sale2.setQuantity(5);

        saleRepository.save(sale);
        saleRepository.save(sale2);
    }
}
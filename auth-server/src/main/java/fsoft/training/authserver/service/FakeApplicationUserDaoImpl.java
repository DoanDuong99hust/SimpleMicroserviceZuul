package fsoft.training.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoImpl implements ApplicationUserDAO{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Arrays.asList(
                new ApplicationUser(
                    "doan",
                        passwordEncoder.encode("pass"),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "shisui",
                        passwordEncoder.encode("pass"),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")),
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }

}

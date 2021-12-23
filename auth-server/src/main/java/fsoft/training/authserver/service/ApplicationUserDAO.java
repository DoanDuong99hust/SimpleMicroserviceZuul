package fsoft.training.authserver.service;

import java.util.Optional;

public interface ApplicationUserDAO {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}

package fsoft.training.authserver.repository;

import fsoft.training.authserver.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findRoleEntityByCode(String code);
    Optional<RoleEntity> findRoleEntityByName(String name);
    Optional<List<RoleEntity>> findAllByCode(String code);
}

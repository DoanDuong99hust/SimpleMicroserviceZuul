package fsoft.training.authserver.repository;

import fsoft.training.authserver.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    @Query("select p from PermissionEntity p where p.roleEntity.roleId = ?1")
    Optional<List<PermissionEntity>> findPermissionByRoleId(Long roleId);
}

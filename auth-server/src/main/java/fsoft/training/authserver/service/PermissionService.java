package fsoft.training.authserver.service;

import fsoft.training.authserver.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> findAll();
    List<PermissionEntity> findPermissionByRoleId(Long roleId);
}

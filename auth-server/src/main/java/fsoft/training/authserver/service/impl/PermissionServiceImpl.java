package fsoft.training.authserver.service.impl;

import fsoft.training.authserver.entity.PermissionEntity;
import fsoft.training.authserver.repository.PermissionRepository;
import fsoft.training.authserver.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<PermissionEntity> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<PermissionEntity> findPermissionByRoleId(Long roleId) {
        return permissionRepository.findPermissionByRoleId(roleId).get();
    }
}

package fsoft.training.authserver.mapper;

import fsoft.training.authserver.entity.PermissionEntity;
import fsoft.training.authserver.entity.RoleEntity;
import fsoft.training.authserver.mapper.dto.RoleResponse;
import fsoft.training.authserver.repository.UserRepository;
import fsoft.training.authserver.service.PermissionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    private final PermissionService permissionService;
    private final UserRepository userRepository;

    public RoleMapper(PermissionService permissionService, UserRepository userRepository) {
        this.permissionService = permissionService;
        this.userRepository = userRepository;
    }

    public RoleResponse mapEntityToResponse(RoleEntity roleEntity) {
        RoleResponse result = new RoleResponse();
        result.setRoleId(roleEntity.getRoleId());
        result.setCode(roleEntity.getCode());
        result.setName(roleEntity.getName());

        List<PermissionEntity> permissionEntities = new ArrayList<>();
        for (PermissionEntity item: permissionService.findPermissionByRoleId(roleEntity.getRoleId())
             ) {
            permissionEntities.add(item);
        }
        result.setPermissionList(permissionEntities);
        return result;
    }
}

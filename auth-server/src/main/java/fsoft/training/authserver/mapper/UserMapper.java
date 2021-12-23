package fsoft.training.authserver.mapper;

import fsoft.training.authserver.entity.PermissionEntity;
import fsoft.training.authserver.entity.RoleEntity;
import fsoft.training.authserver.entity.UserEntity;
import fsoft.training.authserver.mapper.dto.UserRequest;
import fsoft.training.authserver.mapper.dto.UserResponse;
import fsoft.training.authserver.repository.RoleRepository;
import fsoft.training.authserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserMapper {
    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    @Autowired
    public UserMapper(RoleRepository roleRepository, PermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    public UserEntity mapRequestToEntity(UserRequest userRequest) {
        UserEntity result = new UserEntity();
        result.setUserName(userRequest.getUserName());
        result.setPassword(userRequest.getPassword());
        result.setFullName(userRequest.getFullName());
        result.setStatus(userRequest.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (String role: userRequest.getRole()
             ) {
            List<RoleEntity> roleEntities = roleRepository.findAllByCode(role).get();
            roleEntities.stream().forEach(roleEntity -> roleEntitySet.add(roleEntity));
        }
        result.setRoles(roleEntitySet);
        return result;
    }

    public UserResponse mapEntityToResponse(UserEntity userEntity) {
        UserResponse result = new UserResponse();
        result.setUserName(userEntity.getUserName());
        result.setPassword(userEntity.getPassword());
        result.setFullName(userEntity.getFullName());
        result.setStatus(userEntity.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (RoleEntity role: userEntity.getRoles()
        ) {
            List<PermissionEntity> permissionEntities = new ArrayList<>();
            for (PermissionEntity item: permissionService.findPermissionByRoleId(role.getRoleId())
            ) {
                permissionEntities.add(item);
            }
            role.setPermissionList(permissionEntities);
            roleEntitySet.add(role);
        }
        result.setRoleEntity(roleEntitySet);
        return result;
    }

    public UserEntity mapRequestToEntity(UserEntity result, UserRequest userRequest) {
        result.setUserName(userRequest.getUserName());
        result.setPassword(userRequest.getPassword());
        result.setFullName(userRequest.getFullName());
        result.setStatus(userRequest.getStatus());

        Set<RoleEntity> roleEntitySet = new HashSet<>();
        for (String role: userRequest.getRole()
        ) {
            Optional<RoleEntity> roleEntity = roleRepository.findRoleEntityByCode(role);
            roleEntitySet.add(roleEntity.get());
        }
        result.setRoles(roleEntitySet);
        return result;
    }
}

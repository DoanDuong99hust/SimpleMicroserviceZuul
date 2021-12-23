package fsoft.training.authserver.mapper.dto;

import fsoft.training.authserver.entity.PermissionEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleResponse {
    private Long roleId;
    private String name;
    private String code;
    private List<PermissionEntity> permissionList= new ArrayList<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PermissionEntity> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionEntity> permissionList) {
        this.permissionList = permissionList;
    }
}

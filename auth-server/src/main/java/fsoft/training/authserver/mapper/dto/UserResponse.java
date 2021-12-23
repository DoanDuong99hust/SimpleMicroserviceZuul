package fsoft.training.authserver.mapper.dto;

import fsoft.training.authserver.entity.RoleEntity;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponse {
    private String userName;

    private String password;

    private String fullName;

    private Integer status;

    private Set<RoleEntity> roleEntity;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<RoleEntity> getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(Set<RoleEntity> roleEntity) {
        this.roleEntity = roleEntity;
    }
}

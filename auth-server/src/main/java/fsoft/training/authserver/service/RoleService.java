package fsoft.training.authserver.service;

import fsoft.training.authserver.mapper.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAll();
    RoleResponse findRoleByName(String name);
}

package fsoft.training.authserver.service.impl;

import fsoft.training.authserver.entity.RoleEntity;
import fsoft.training.authserver.mapper.RoleMapper;
import fsoft.training.authserver.mapper.dto.RoleResponse;
import fsoft.training.authserver.repository.RoleRepository;
import fsoft.training.authserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleResponse> findAll() {
        List<RoleResponse> roleResponses = new ArrayList<>();
        for (RoleEntity item: roleRepository.findAll()
             ) {
            roleResponses.add(roleMapper.mapEntityToResponse(item));
        }
        return roleResponses;
    }

    @Override
    public RoleResponse findRoleByName(String name) {
        RoleResponse roleResponse = roleMapper.mapEntityToResponse(roleRepository.findRoleEntityByName(name).get());
        return roleResponse;
    }

}

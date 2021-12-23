package fsoft.training.authserver.service;


import fsoft.training.authserver.entity.UserEntity;
import fsoft.training.authserver.mapper.dto.UserRequest;
import fsoft.training.authserver.mapper.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();
    List<UserEntity> findUsers();
    UserEntity findById(Long id);
    UserResponse save(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    void delete(Long id);
}

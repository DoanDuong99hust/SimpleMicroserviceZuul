package fsoft.training.authserver.controller;

import fsoft.training.authserver.mapper.dto.UserRequest;
import fsoft.training.authserver.mapper.dto.UserResponse;
import fsoft.training.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/get-users")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest) {
        userRequest.setUserId(userId);
        return ResponseEntity.ok(userService.update(userRequest));
    }

    @DeleteMapping(value = "/delete/{userId}")
    public void delete(@PathVariable("userId") Long id) {
        userService.delete(id);
    }
}

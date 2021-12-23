package fsoft.training.authserver.controller;

import fsoft.training.authserver.mapper.dto.RoleResponse;
import fsoft.training.authserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleResponse>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<RoleResponse> findRoleByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(roleService.findRoleByName(name));
    }
}

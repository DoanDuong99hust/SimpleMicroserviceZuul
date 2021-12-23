package fsoft.training.authserver.controller;

import fsoft.training.authserver.entity.PermissionEntity;
import fsoft.training.authserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<PermissionEntity>> findAll() {
        return ResponseEntity.ok(permissionService.findAll());
    }
}

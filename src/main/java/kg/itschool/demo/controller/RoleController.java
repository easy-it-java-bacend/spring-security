package kg.itschool.demo.controller;

import kg.itschool.demo.model.dto.RoleDto;
import kg.itschool.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @PreAuthorize("hasAuthority('ROLE_CREATE')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RoleDto roleDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(roleDto));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('PERMISSIONS_READ')")
    @GetMapping("/get-all-authorities")
    public ResponseEntity<?> getAllAuthorities() {
        return ResponseEntity.ok(roleService.getAuthorities());
    }
}

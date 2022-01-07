package kg.itschool.demo.controller;

import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.request.CreateUserRequest;
import kg.itschool.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('USER_CREATE')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateUserRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('USER_UPDATE')")
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserDto userDto){
        try {
            return ResponseEntity.ok(userService.update(userDto));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('USER_DELETE')")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('USER_READ')")
    @GetMapping("/read")
    public  ResponseEntity<?> read(@RequestBody Long id){
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(userService.findById(id));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
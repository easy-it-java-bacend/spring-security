package kg.itschool.demo.service;

import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.User;
import kg.itschool.demo.model.request.CreateUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    UserDto create(CreateUserRequest request);
    UserDto findById(Long id);
    UserDto update(UserDto userDto);
    UserDto delete(Long id);
}

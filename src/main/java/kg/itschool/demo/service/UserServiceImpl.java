package kg.itschool.demo.service;

import kg.itschool.demo.mapper.UserMapper;
import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.Role;
import kg.itschool.demo.model.entity.User;
import kg.itschool.demo.model.request.CreateUserRequest;
import kg.itschool.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //ORM -> Object Relational Mapping
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email: " + request.getEmail() + " already in use");
        }

        if (request.getUsername() == null || request.getUsername().trim().equals("")) {
            request.setUsername(request.getEmail().substring(0, request.getEmail().indexOf('@')));
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username: " + request.getUsername() + " already in use");
        }

        User user = User
                .builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Username: " + username + " not found."));
    }
}

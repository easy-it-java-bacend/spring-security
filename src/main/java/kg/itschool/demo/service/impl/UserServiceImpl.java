package kg.itschool.demo.service.impl;

import kg.itschool.demo.mapper.UserMapper;
import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.User;
import kg.itschool.demo.model.request.CreateUserRequest;
import kg.itschool.demo.repository.UserRepository;
import kg.itschool.demo.service.AccountService;
import kg.itschool.demo.service.UserService;
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
    @Autowired
    private AccountService accountService;

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


        UserDto userDto = UserMapper.INSTANCE.toDto(user);

        AccountDto accountDto = AccountDto.builder()
                .userDto(userDto)
                .transactions(null)
                .notes("asd")
                .availableMoney(0L)
                .accountName("asd")
                .build();

        accountService.create(accountDto);

        return userDto;
    }

    @Override
    public UserDto findById(Long id) {
        return UserMapper.INSTANCE.toDto(userRepository.findByIdAndIsActiveTrue(id).orElseThrow(()-> new RuntimeException("User not found")));
    }

    @Override
    public UserDto update(UserDto userDto) {

        User userEntity = userRepository.findByIdAndIsActiveTrue(userDto.getId()).map(user -> {
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            return userRepository.save(user);
        }).orElseThrow(()-> new RuntimeException("Not found"));

        return UserMapper.INSTANCE.toDto(userEntity);
    }

    @Override
    public UserDto delete(Long id) {

        User userEntity = userRepository.findByIdAndIsActiveTrue(id).map(user -> {
            user.setIsActive(false);
            return userRepository.save(user);
        }).orElseThrow(()-> new RuntimeException("Not found"));

        return UserMapper.INSTANCE.toDto(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Username: " + username + " not found."));
    }
}

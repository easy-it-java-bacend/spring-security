package kg.itschool.demo.service;

import kg.itschool.demo.model.dto.RoleDto;
import kg.itschool.demo.model.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    List<Authority> getAuthorities();
    RoleDto create(RoleDto roleDto);

}

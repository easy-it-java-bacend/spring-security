package kg.itschool.demo.service.impl;

import kg.itschool.demo.mapper.RoleMapper;
import kg.itschool.demo.model.dto.RoleDto;
import kg.itschool.demo.model.entity.Authority;
import kg.itschool.demo.repository.RoleRepository;
import kg.itschool.demo.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Authority> getAuthorities() {
        return Stream.of(Authority.values()).collect(Collectors.toList());
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        return RoleMapper.INSTANCE
                .toDto(roleRepository
                        .save(RoleMapper.INSTANCE
                                .toEntity(roleDto)));
    }
}

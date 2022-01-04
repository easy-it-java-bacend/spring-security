package kg.itschool.demo.mapper;

import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.User;

import java.util.List;

public interface BaseMapper<ENTITY, DTO> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
    List<ENTITY> entityList(List<DTO> dtoList);
    List<DTO> dtoList(List<ENTITY> entityList);
}

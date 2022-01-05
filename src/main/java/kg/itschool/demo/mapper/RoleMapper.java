package kg.itschool.demo.mapper;

import kg.itschool.demo.model.dto.RoleDto;
import kg.itschool.demo.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDto> {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}

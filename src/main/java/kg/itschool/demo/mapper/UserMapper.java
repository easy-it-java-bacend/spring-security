package kg.itschool.demo.mapper;

import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
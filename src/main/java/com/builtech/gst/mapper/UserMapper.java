package com.builtech.gst.mapper;

import com.builtech.gst.dto.UserDto;
import com.builtech.gst.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "email", target = "username"),
            @Mapping(target = "role", expression = "java(user.getRole().getRole())")
    })
    UserDto userToUserDto(User user);

}

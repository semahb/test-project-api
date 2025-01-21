package io.glide.boot.converter;

import io.glide.boot.api.dto.UserDto;
import io.glide.boot.api.dto.UserRegistrationDto;
import io.glide.boot.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private ModelMapper modelMapper ;


    public UserConverter() {
    }

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public User convertRegistrationDtoToUser (UserRegistrationDto registrationDto) {
        return modelMapper.map(registrationDto, User.class);

    }

    public UserDto convertUserToUserDto (User user) {
        return modelMapper.map(user, UserDto.class);

    }
}

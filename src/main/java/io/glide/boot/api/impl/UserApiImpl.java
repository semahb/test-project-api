package io.glide.boot.api.impl;

import io.glide.boot.api.UserApi;
import io.glide.boot.api.dto.UserDto;
import io.glide.boot.api.dto.UserRegistrationDto;
import io.glide.boot.converter.UserConverter;
import io.glide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserApiImpl implements UserApi {

  private UserService userService;
  private UserConverter userConverter ;

  public UserApiImpl() {
  }

  public UserApiImpl(UserService userService, UserConverter userConverter) {
    this.userService = userService;
    this.userConverter = userConverter;
  }
  @Override
  public UserDto register(final UserRegistrationDto userRegistrationDto) {
    return userConverter.convertUserToUserDto(userService.registerUser(userRegistrationDto));
  }

  @Override
  public Mono<UserDto> findUserById(long id) {
    return  Mono.just(userConverter.convertUserToUserDto( userService.getById(id).block()));
  }
}

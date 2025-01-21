package io.glide.boot.api;

import io.glide.boot.api.dto.UserDto;
import io.glide.boot.api.dto.UserRegistrationDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public interface UserApi {

  /**
   * Register a new user.
   *
   * @param userRegistrationDto DTO that input data needed to register a new user.
   * @return registered user infos.
   */
  @PostMapping("/users/register")
  UserDto register(@RequestBody @NotNull @Valid UserRegistrationDto userRegistrationDto);

  /**
   * Get user details by id.
   *
   * @param id user id
   * @return user infos
   */
  @GetMapping("/users/{userId}")
  Mono<UserDto> findUserById(@PathVariable("userId") long id);
}

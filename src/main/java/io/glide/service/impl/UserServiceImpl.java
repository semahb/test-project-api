package io.glide.service.impl;

import io.glide.boot.converter.UserConverter;
import io.glide.boot.domain.User;
import io.glide.boot.api.dto.UserRegistrationDto;
import io.glide.boot.repository.UserRepository;
import io.glide.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserConverter userConverter ;

  /**
   *
   * @param userRegistrationDto dto for user registration.
   * @return Created user
   */
  @Override
  public User registerUser(final UserRegistrationDto userRegistrationDto) {
    return userRepository.save(userConverter.convertRegistrationDtoToUser(userRegistrationDto));
  }

  /**
   *
   * @param id user id.
   * @return a Mono containing the User if found, or an error if the user does not exist
   */
  @Override
  public Mono<User> getById(final long id) {
    Optional<User> user = userRepository.findById(id);
    return (user.isPresent())
            ? Mono.justOrEmpty(user)
            : Mono.error(new NotFoundException("User not found"));
  }
}

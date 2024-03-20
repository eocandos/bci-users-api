package cl.com.users.api.services.impl;

import cl.com.users.api.constants.ErrorMessages;
import cl.com.users.api.exception.CustomException;
import cl.com.users.api.repository.UserRepository;
import cl.com.users.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.com.users.api.model.User;
import cl.com.users.api.security.JwtTokenProvider;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  @Override
  public User register(User user) {
    if (!userRepository.existsByEmail(user.getEmail())) {
      user.setActive(true);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setToken(jwtTokenProvider.createToken(user.getEmail(), user.getAppUserRoles()));
      return userRepository.save(user);
    } else {
      throw new CustomException(ErrorMessages.ERROR_EMAIL_ALREADY_EXIST, HttpStatus.FORBIDDEN);
    }
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }


}
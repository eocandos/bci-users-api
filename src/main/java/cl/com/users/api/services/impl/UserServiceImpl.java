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

import java.util.Date;
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
  public User register(User appUser) {
    if (!userRepository.existsByEmail(appUser.getEmail())) {
      appUser.setActive(true);
      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
      appUser.setToken(jwtTokenProvider.createToken(appUser.getEmail(), appUser.getAppUserRoles()));
      return userRepository.save(appUser);
    } else {
      throw new CustomException(ErrorMessages.ERROR_EMAIL_ALREADY_EXIST, HttpStatus.FORBIDDEN);
    }
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public String refreshToken(String email) {
    return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getAppUserRoles());
  }
  @Override
  public void updateStatusUser(String email, String token) {
    User oldUser = userRepository.findByEmail(email);
    oldUser.setToken(token);
    oldUser.setLastLogin(new Date());
    userRepository.save(oldUser);
  }

}

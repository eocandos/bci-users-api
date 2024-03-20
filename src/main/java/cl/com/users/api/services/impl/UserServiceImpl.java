package cl.com.users.api.services.impl;

import cl.com.users.api.exception.CustomException;
import cl.com.users.api.model.AppUser;
import cl.com.users.api.repository.UserRepository;
import cl.com.users.api.security.JwtTokenProvider;
import cl.com.users.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  @Override
  public String login(String email, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
      return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getAppUserRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid email/password supplied", HttpStatus.UNAUTHORIZED);
    }
  }

  @Override
  public AppUser register(AppUser appUser) {
    if (!userRepository.existsByEmail(appUser.getEmail())) {
      appUser.setActive(true);
      appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
      appUser.setToken(jwtTokenProvider.createToken(appUser.getEmail(), appUser.getAppUserRoles()));
      return userRepository.save(appUser);
    } else {
      throw new CustomException("email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  @Override
  public AppUser find(String email) {
    AppUser appUser = userRepository.findByEmail(email);
    if (appUser == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return appUser;
  }


}

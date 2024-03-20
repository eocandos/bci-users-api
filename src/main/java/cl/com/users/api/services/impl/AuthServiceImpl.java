package cl.com.users.api.services.impl;

import cl.com.users.api.constants.ErrorMessages;
import cl.com.users.api.exception.CustomException;
import cl.com.users.api.repository.UserRepository;
import cl.com.users.api.security.JwtTokenProvider;
import cl.com.users.api.services.AuthService;
import cl.com.users.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  @Autowired
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public UserService userService;

  @Override
  public String login(String email, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
      String token = jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getAppUserRoles());
      return token;
    } catch (AuthenticationException e) {
      throw new CustomException(ErrorMessages.ERROR_UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
    }
  }

}

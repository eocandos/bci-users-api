package cl.com.users.api.security;

import cl.com.users.api.constants.ErrorMessages;
import cl.com.users.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import cl.com.users.api.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    final User appUser = userRepository.findByEmail(email);

    if (appUser == null) {
      throw new UsernameNotFoundException(ErrorMessages.ERROR_USER_DONT_EXIST);
    }

    return org.springframework.security.core.userdetails.User
        .withUsername(email)
        .password(appUser.getPassword())
        .authorities(appUser.getAppUserRoles())
        .accountExpired(false)
        .accountLocked(false)
        .credentialsExpired(false)
        .disabled(false)
        .build();
  }

}

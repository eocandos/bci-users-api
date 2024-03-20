package cl.com.users.api.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
  ROLE_ADMIN, ROLE_USER;

  public String getAuthority() {
    return name();
  }

}

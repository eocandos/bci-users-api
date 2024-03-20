package cl.com.users.api.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
  ROLE_ADMIN;

  public String getAuthority() {
    return name();
  }

}

package cl.com.users.api.services;

import cl.com.users.api.model.AppUser;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    String login(String email, String password);
    AppUser find(String email);
    AppUser register(AppUser user);

}

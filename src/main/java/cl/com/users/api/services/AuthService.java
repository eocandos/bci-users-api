package cl.com.users.api.services;

import cl.com.users.api.model.User;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    String login(String email, String password);

    User checkToken(HttpServletRequest req);

    String refreshToken(String email);


}

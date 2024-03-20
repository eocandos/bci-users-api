package cl.com.users.api.services;

import cl.com.users.api.model.User;
import java.util.List;

public interface UserService {

    List<User> getAll();
    User register(User user);
    String refreshToken(String email);
    void updateStatusUser(String email, String token);

}

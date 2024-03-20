package cl.com.users.api.services;

import cl.com.users.api.model.User;
import java.util.List;

public interface UserService {

    List<User> getAll();
    User register(User user);


}

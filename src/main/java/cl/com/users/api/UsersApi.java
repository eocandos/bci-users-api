package cl.com.users.api;

import cl.com.users.api.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class UsersApi {

  final UserServiceImpl userService;

  public static void main(String[] args) {
    SpringApplication.run(UsersApi.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}

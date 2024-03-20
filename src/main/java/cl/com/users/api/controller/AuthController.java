package cl.com.users.api.controller;

import cl.com.users.api.services.impl.AuthServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Api(tags = "auth")
@RequiredArgsConstructor
public class AuthController {

  @Autowired
  private AuthServiceImpl authService;

  @PostMapping("/login")
  @ApiOperation(value = "${UserController.login}")
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = "Something went wrong"),
          @ApiResponse(code = 422, message = "Invalid email/password supplied")})
  public String login(
          @ApiParam("email") @RequestParam String email,
          @ApiParam("Password") @RequestParam String password) {
    return authService.login(email, password);
  }


}

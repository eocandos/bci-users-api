package cl.com.users.api.controller;

import cl.com.users.api.constants.ErrorMessages;
import cl.com.users.api.services.impl.AuthServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
          @ApiResponse(code = 400, message = ErrorMessages.ERROR_SOMETHING_WRONG),
          @ApiResponse(code = 422, message = ErrorMessages.ERROR_EMAIL_OR_PASSWORD)})
  public String login(
          @ApiParam("email") @RequestParam String email,
          @ApiParam("Password") @RequestParam String password) {
    return authService.login(email, password);
  }

  @GetMapping("/refresh")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  public String refreshToken(HttpServletRequest req) {
    return authService.refreshToken(req.getRemoteUser());
  }


}

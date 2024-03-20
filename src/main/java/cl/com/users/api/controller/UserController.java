package cl.com.users.api.controller;

import cl.com.users.api.constants.ErrorMessages;
import lombok.RequiredArgsConstructor;
import cl.com.users.api.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import cl.com.users.api.dto.UserDataDTO;
import cl.com.users.api.dto.UserResponseDTO;
import cl.com.users.api.services.impl.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {

  @Autowired
  private UserServiceImpl userService;
  private final ModelMapper modelMapper;

  @GetMapping(value = "/users")
  @PreAuthorize("hasRole('ROLE_USER')")
  @ApiOperation(value = "${UserController.find}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = ErrorMessages.ERROR_SOMETHING_WRONG),
          @ApiResponse(code = 403, message = ErrorMessages.ERROR_ACCESS_DENIED),
          @ApiResponse(code = 404, message = ErrorMessages.ERROR_USER_DONT_EXIST),
          @ApiResponse(code = 500, message = ErrorMessages.ERROR_EXPIRED_OR_INVALID_JWT_TOKEN)})
  public ResponseEntity<List<User>> geUsers() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/users")
  @ApiOperation(value = "${UserController.register}")
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = ErrorMessages.ERROR_SOMETHING_WRONG),
          @ApiResponse(code = 403, message = ErrorMessages.ERROR_ACCESS_DENIED),
          @ApiResponse(code = 422, message = ErrorMessages.ERROR_EMAIL_ALREADY_EXIST)})
  public User register(@ApiParam("register User") @RequestBody UserDataDTO user) {
    return userService.register(modelMapper.map(user, User.class));
  }


}

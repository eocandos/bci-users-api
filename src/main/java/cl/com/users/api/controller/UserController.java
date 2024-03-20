package cl.com.users.api.controller;

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
          @ApiResponse(code = 400, message = "Something went wrong"),
          @ApiResponse(code = 403, message = "Access denied"),
          @ApiResponse(code = 404, message = "The user doesn't exist"),
          @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public ResponseEntity<List<User>> geUsers() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/users")
  @ApiOperation(value = "${UserController.register}")
  @ApiResponses(value = {
          @ApiResponse(code = 400, message = "Something went wrong"),
          @ApiResponse(code = 403, message = "Access denied"),
          @ApiResponse(code = 422, message = "email is already in use")})
  public User register(@ApiParam("register User") @RequestBody UserDataDTO user) {
    return userService.register(modelMapper.map(user, User.class));
  }


}

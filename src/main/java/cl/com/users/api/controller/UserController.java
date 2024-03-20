package cl.com.users.api.controller;

import cl.com.users.api.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import cl.com.users.api.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cl.com.users.api.dto.UserDataDTO;

@RestController
@RequestMapping("/api")
@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    private final ModelMapper modelMapper;

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

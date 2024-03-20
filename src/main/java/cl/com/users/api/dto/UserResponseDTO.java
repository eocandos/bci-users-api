package cl.com.users.api.dto;

import cl.com.users.api.model.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {

  @ApiModelProperty(position = 0)
  private Integer id;

  @ApiModelProperty(position = 1)
  private String email;
  
  @ApiModelProperty(position = 3)
  List<UserRole> appUserRoles;

}

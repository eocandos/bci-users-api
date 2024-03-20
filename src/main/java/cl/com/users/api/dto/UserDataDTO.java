package cl.com.users.api.dto;

import cl.com.users.api.model.Phone;
import cl.com.users.api.model.UserRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDataDTO {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "userId", updatable = false, nullable = false)
  private UUID userId;

  @NaturalId
  @NotEmpty
  @Pattern(regexp = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
  private String email;

  @NotEmpty
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
          message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
  private String password;

  private String token;

  @NotEmpty
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Phone> phones;

  private boolean isActive;

  @ApiModelProperty(position = 3)
  List<UserRole> appUserRoles;

  @CreationTimestamp
  private Date created;

  @UpdateTimestamp
  private Date modified;

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", token='" + token + '\'' +
            ", name='" + name + '\'' +
            ", isActive=" + isActive +
            '}';
  }

}

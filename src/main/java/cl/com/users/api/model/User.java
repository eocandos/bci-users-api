package cl.com.users.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
public class User {

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
  private String password;

  private String token;

  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Phone> phones;

  private boolean isActive;

  @ElementCollection(fetch = FetchType.EAGER)
  List<UserRole> appUserRoles;

  @CreationTimestamp
  private Date created;

  @UpdateTimestamp
  private Date modified;

  @CreationTimestamp
  private Date lastLogin;

}

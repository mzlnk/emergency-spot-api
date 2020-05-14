package pl.mzlnk.emergencyspotapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends IdentifiableEntity {

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_role_id")})
    private Set<Role> roles;

}

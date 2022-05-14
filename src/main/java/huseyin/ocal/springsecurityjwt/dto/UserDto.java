package huseyin.ocal.springsecurityjwt.dto;

import huseyin.ocal.springsecurityjwt.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String username;

    private String password;

    private Collection<Role> roles;
}

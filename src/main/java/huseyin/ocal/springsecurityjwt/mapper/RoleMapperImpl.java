package huseyin.ocal.springsecurityjwt.mapper;

import huseyin.ocal.springsecurityjwt.domain.Role;
import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toRole(RoleDto roleDto) {
        return Role.builder()
            .name(roleDto.getName())
            .build();
    }
}

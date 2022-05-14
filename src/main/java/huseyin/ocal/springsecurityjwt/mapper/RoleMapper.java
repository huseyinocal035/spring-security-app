package huseyin.ocal.springsecurityjwt.mapper;

import huseyin.ocal.springsecurityjwt.domain.Role;
import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;

public interface RoleMapper {

    Role toRole(RoleDto roleDto);

}

package huseyin.ocal.springsecurityjwt.service;

import huseyin.ocal.springsecurityjwt.domain.Role;
import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.RoleToUserDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;

import java.util.List;

public interface UserService {

    User saveUser(UserDto userDto);

    Role saveRole(RoleDto roleDto);

    void addRoleToUser(RoleToUserDto roleToUserDto);

    User getUser(String username);

    List<User> getUsers();
}

package huseyin.ocal.springsecurityjwt.service;

import huseyin.ocal.springsecurityjwt.domain.Role;
import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.RoleToUserDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;
import huseyin.ocal.springsecurityjwt.mapper.RoleMapper;
import huseyin.ocal.springsecurityjwt.mapper.UserMapper;
import huseyin.ocal.springsecurityjwt.repository.RoleRepository;
import huseyin.ocal.springsecurityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;

    @Override
    public User saveUser(UserDto userDto) {
        log.info("Saving new user {} to database successfully.", userDto.getName());
        User user = userMapper.toUser(userDto);
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(RoleDto roleDto) {
        log.info("Saving new role {} to database successfully.", roleDto.getName());
        Role role = roleMapper.toRole(roleDto);
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(RoleToUserDto roleToUserDto) {
        log.info("Saving role {} to user {}.", roleToUserDto.getRoleName(), roleToUserDto.getUsername());
        User user = userRepository.findByUsername(roleToUserDto.getUsername());
        Role role = roleRepository.findByName(roleToUserDto.getRoleName());
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user {}.", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all users.");
        return userRepository.findAll();
    }
}

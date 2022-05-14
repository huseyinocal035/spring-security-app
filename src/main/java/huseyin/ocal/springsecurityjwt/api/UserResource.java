package huseyin.ocal.springsecurityjwt.api;

import huseyin.ocal.springsecurityjwt.domain.Role;
import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.RoleToUserDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;
import huseyin.ocal.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody UserDto userDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userDto));
    }

    @PostMapping("/roles/save")
    public ResponseEntity<Role> saveRole(@RequestBody RoleDto roleDto) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/roles/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roleDto));
    }

    @PostMapping("/roles/add-to-user")
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserDto roleToUserDto) {
        userService.addRoleToUser(roleToUserDto);
        return ResponseEntity.ok().build();
    }

}

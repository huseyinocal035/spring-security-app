package huseyin.ocal.springsecurityjwt;

import huseyin.ocal.springsecurityjwt.dto.RoleDto;
import huseyin.ocal.springsecurityjwt.dto.RoleToUserDto;
import huseyin.ocal.springsecurityjwt.dto.UserDto;
import huseyin.ocal.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new RoleDto(null, "ROLE_USER"));
            userService.saveRole(new RoleDto(null, "ROLE_MANAGER"));
            userService.saveRole(new RoleDto(null, "ROLE_ADMIN"));
            userService.saveRole(new RoleDto(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new UserDto(null, "Hüseyin Öcal", "huseyinocal", "12345", new ArrayList<>()));
            userService.saveUser(new UserDto(null, "Okan Öcal", "okanocal", "12345", new ArrayList<>()));
            userService.saveUser(new UserDto(null, "Mustafa Öcal", "mustafaocal", "12345", new ArrayList<>()));
            userService.saveUser(new UserDto(null, "Yelda Öcal", "yeldaocal", "12345", new ArrayList<>()));

            userService.addRoleToUser(new RoleToUserDto("huseyinocal", "ROLE_USER"));
            userService.addRoleToUser(new RoleToUserDto("huseyinocal", "ROLE_MANAGER"));
            userService.addRoleToUser(new RoleToUserDto("okanocal", "ROLE_MANAGER"));
            userService.addRoleToUser(new RoleToUserDto("mustafaocal", "ROLE_ADMIN"));
            userService.addRoleToUser(new RoleToUserDto("yeldaocal", "ROLE_USER"));
            userService.addRoleToUser(new RoleToUserDto("yeldaocal", "ROLE_ADMIN"));
            userService.addRoleToUser(new RoleToUserDto("yeldaocal", "ROLE_SUPER_ADMIN"));
            userService.addRoleToUser(new RoleToUserDto("yeldaocal", "ROLE_MANAGER"));
        };
    }
}

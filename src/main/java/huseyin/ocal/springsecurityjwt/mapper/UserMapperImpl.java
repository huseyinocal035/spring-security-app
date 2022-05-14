package huseyin.ocal.springsecurityjwt.mapper;

import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDto userDto) {
        return User.builder()
            .name(userDto.getName())
            .username(userDto.getUsername())
            .password(userDto.getPassword())
            .roles(userDto.getRoles())
            .build();
    }
}

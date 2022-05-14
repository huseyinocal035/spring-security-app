package huseyin.ocal.springsecurityjwt.mapper;

import huseyin.ocal.springsecurityjwt.domain.User;
import huseyin.ocal.springsecurityjwt.dto.UserDto;

public interface UserMapper {

    User toUser(UserDto userDto);

}

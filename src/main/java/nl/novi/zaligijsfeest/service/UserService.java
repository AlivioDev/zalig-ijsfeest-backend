package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;

public interface UserService {
    UserDto getUser(String username);
    UserDto addUser(UserDto userDto);
}

package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUser(String username);
    UserDto addUser(UserDto userDto);
    void deleteUser(String username);
    UserDto updateUser(String username, UserDto userDto);
}

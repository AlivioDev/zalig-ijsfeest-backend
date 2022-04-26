package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.model.Authority;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUser(String username);
    UserDto addUser(UserDto userDto);
    void deleteUser(String username);
    UserDto updateUser(String username, UserDto userDto);
    Set<Authority> getAuthorities(String username);

    void addAuthority(String username, String authority) ;

    void removeAuthority(String username, String authority) ;
}

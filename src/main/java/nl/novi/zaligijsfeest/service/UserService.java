package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.model.Authority;

import java.util.List;
import java.util.Set;

public interface UserService {

    //Methode voor het ophalen van alle gebruikers
    List<UserDto> getUsers();

    //Methode voor het opvragen van een gebruiker
    UserDto getUser(String username);

    //Methode voor het toevoegen van een gebruiker
    String createUser(UserDto userDto);

    //Methode voor het verwijderen van een gebruiker
    void deleteUser(String username);

    //Methode voor het wijzigen van een gebruiker
    UserDto updateUser(String username, UserDto userDto);

    //Methode om de toestemming/toegang van een gebruiker op te vragen
    Set<Authority> getAuthorities(String username);

    //Methode om toestemming/toegang aan een gebruiker toe te wijzen
    void addAuthority(String username, String authority);

    //Methode om de toestemming/toegang van een gebruiker te verwijderen
    void removeAuthority(String username, String authority);
}

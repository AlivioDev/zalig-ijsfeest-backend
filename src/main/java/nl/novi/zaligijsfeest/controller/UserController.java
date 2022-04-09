package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.exception.BadRequestException;
import nl.novi.zaligijsfeest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {

    //Koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    private UserService userService;

    //een GET-request voor alle gebruikers
    @GetMapping(path = "")
    public ResponseEntity<Object> getUsers() {
        List<UserDto> userDtoList = userService.getUsers();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    //en GET-request voor 1 user via gebruikersnaam
    @GetMapping(path = "/{username}")
    public ResponseEntity<Object> getUserByUserName(@PathVariable("username") String username) {
        UserDto userDto = userService.getUser(username);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //een POST-request voor 1 gebruiker
    @PostMapping(path = "")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        String user = userService.createUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(user).toUri();
        return ResponseEntity.created(location).build();
    }

    //een DELETE-request voor 1 gebruiker
    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    //een PUT-request voor 1 gebruiker
    @PutMapping(path = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(username, userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //een GET-request voor het opvragen van de toestemming/toegang van de gebruiker
    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    //een POST-request voor het toewijzen van toestemming/toegang aan een gebruiker
    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    //een DELETE-request voor het verwijderen van toestemming/toegang van een gebruiker
    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}

package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 gebruiker
    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("Gebruiker met gebruikersnaam " + username + " verwijderd.", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 gebruiker
    @PutMapping(path = "/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(username, userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.exception.BadRequestException;
import nl.novi.zaligijsfeest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
//@RequestMapping(path = "/users")
public class UserController {

    //Koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    private UserService userService;

    //een GET-request voor alle gebruikers
    @GetMapping(path = "/admin/users")
    public ResponseEntity<Object> getUsers() {
        List<UserDto> userDtoList = userService.getUsers();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    //en GET-request voor 1 user via gebruikersnaam
    @GetMapping(path = "/users/{username}")
    public ResponseEntity<Object> getUserByUserName(@PathVariable("username") String username) {
        UserDto userDto = userService.getUser(username);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    //een POST-request voor 1 gebruiker
    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 gebruiker
    @DeleteMapping(path = "/admin/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("Gebruiker met gebruikersnaam " + username + " verwijderd.", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 gebruiker
    @PutMapping(path = "/users/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(username, userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/admin/{username}/authorities")
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

    @DeleteMapping(value = "/admin/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{id}/{order}")
    public ResponseEntity<Object> assignToUser(@PathVariable("id") String userId,
                                               @PathVariable("order") Long orderId){
        userService.assignOrderToUser(userId, orderId);
        return ResponseEntity.noContent().build();
    }
}

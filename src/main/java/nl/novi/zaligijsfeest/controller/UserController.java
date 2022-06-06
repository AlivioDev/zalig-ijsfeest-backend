package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/{username}")
    public ResponseEntity<Object> getUserByUserName(@PathVariable("username") String username) {
        UserDto userDto = userService.getUser(username);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
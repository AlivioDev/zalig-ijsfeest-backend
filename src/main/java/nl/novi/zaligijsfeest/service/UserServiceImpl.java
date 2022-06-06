package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.model.User;
import nl.novi.zaligijsfeest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(@Lazy UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto getUser(String username) {
        UserDto userDto;
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
            userDto = fromUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
        return userDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userDto;
    }

    public User toUser(UserDto userDto) {
        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAuthorities(userDto.getAuthorities());

        return user;
    }

    public static UserDto fromUser(User user) {
        var userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAuthorities(user.getAuthorities());

        return userDto;
    }

}

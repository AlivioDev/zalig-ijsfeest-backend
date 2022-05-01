package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.Authority;
import nl.novi.zaligijsfeest.model.Order;
import nl.novi.zaligijsfeest.model.User;
import nl.novi.zaligijsfeest.repository.OrderRepository;
import nl.novi.zaligijsfeest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    //Koppeling met de repository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OrderRepository orderRepository;

    //Methode voor het ophalen van alle gebruikers
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            userDtoList.add(fromUser(user));
        }
        return userDtoList;
    }

    //Methode voor het opvragen van een gebruiker
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

    //Methode voor het toevoegen van een gebruiker
    @Override
    public UserDto addUser(UserDto userDto) {
        User user = toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userDto;
    }

    //Methode voor het verwijderen van een gebruiker
    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    //Methode voor het wijzigen van een gebruiker
    @Override
    public UserDto updateUser(String username, UserDto userDto) {
        if (userRepository.existsById(username)) {
            User user = userRepository.findById(username).get();

            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setRole(userDto.getRole());
            user.setAuthorities(userDto.getAuthorities());

            userRepository.save(user);
            return userDto;
        } else {
            throw new RecordNotFoundException("Geen gegevens gevonden met gebruikersnaam " + username + ".");
        }
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public void assignOrderToUser(String userId, Long orderId){
        Optional<User> optionalUser= userRepository.findById(userId);
        Optional<Order> optionalOrder= orderRepository.findById(orderId);
        if(optionalOrder.isPresent() && optionalUser.isPresent()){
            User user = optionalUser.get();
            Order order = optionalOrder.get();
            List<Order> orders = user.getOrders();
            orders.add(order);
            user.setOrders(orders);
            userRepository.save(user);
        }
    }

    //Methode om de gegevens vanuit de dto aan de entity door te geven
    public User toUser(UserDto userDto) {
        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRole(userDto.getRole());
        user.setAuthorities(userDto.getAuthorities());

        return user;
    }

    //Methode om de gegevens vanuit de entity door te geven aan de dto
    public static UserDto fromUser(User user) {
        var userDto = new UserDto();

        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setRole(user.getRole());
        userDto.setAuthorities(user.getAuthorities());

        return userDto;
    }

}

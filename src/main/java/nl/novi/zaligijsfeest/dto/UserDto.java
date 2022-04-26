package nl.novi.zaligijsfeest.dto;

import nl.novi.zaligijsfeest.model.Authority;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserDto {

    //Variabelen
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    // hier de check verwijderd omdat ik daarvoor in de frontend een iets betere check heb gemaakt
    private String phoneNumber;

    private Set<Authority> authorities;


    //Constructors
    //Default
    public UserDto() {
    }

    //volledig exclusief foto
    public UserDto(String username, String password, String email, String firstName, String lastName, String phoneNumber, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
    }

    //Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    //Setters
    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = (password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}

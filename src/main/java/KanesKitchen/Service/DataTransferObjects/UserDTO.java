package KanesKitchen.Service.DataTransferObjects;

import KanesKitchen.Models.Role;

import java.util.Collection;

public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String nickName;
    private String password;
    private Collection<Role> roles;

    public UserDTO(String firstName, String lastName, int age, String email, String nickName, String password, Collection<Role> roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.roles = roles;
    }

    public UserDTO(String email, String nickName, long id) {
        this.email = email;
        this.nickName = nickName;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

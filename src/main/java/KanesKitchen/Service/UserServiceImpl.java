package KanesKitchen.Service;

import KanesKitchen.Models.Role;
import KanesKitchen.Models.User;
import KanesKitchen.Repositories.RoleRepository;
import KanesKitchen.Repositories.UserRepository;
import KanesKitchen.Service.DataTransferObjects.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserDTO registrationDTO) {
       User user = new User(
               registrationDTO.getFirstName(),
               registrationDTO.getLastName(),
               registrationDTO.getAge(),
               registrationDTO.getEmail(),
               registrationDTO.getNickName(),
               passwordEncoder.encode(registrationDTO.getPassword()),
               Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public User findUserByNick(String nick) {
        return userRepository.findByNickName(nick);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToUserDto(User user) {
        return new UserDTO(user.getEmail(), user.getNickName(), user.getId());
    }

}

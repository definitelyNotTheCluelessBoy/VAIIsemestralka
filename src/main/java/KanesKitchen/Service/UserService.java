package KanesKitchen.Service;

import KanesKitchen.Models.User;
import KanesKitchen.Service.DataTransferObjects.UserDTO;

import java.util.List;

public interface UserService {
    User save(UserDTO registrationDTO);
    User findUserByEmail(String email);
    List<UserDTO> findAllUsers();

    User findUserByNick(String nick);

    void deleteUser(long id);
}

package KanesKitchen.Controllers;

import KanesKitchen.Models.User;
import KanesKitchen.Service.DataTransferObjects.UserDTO;
import KanesKitchen.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String showRegistrationForm(Model model){
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDto,
                               BindingResult result,
                               Model model){
        User existingUserWithEmail = userService.findUserByEmail(userDto.getEmail());
        User existingUserWithNick = userService.findUserByNick(userDto.getNickName());

        if(existingUserWithEmail != null){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(existingUserWithNick != null){
            result.rejectValue("nickName", null,
                    "There is already an account registered with the same nick name");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/usersDisplay")
    public String users(Model model){
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "usersDisplay";
    }

    @GetMapping("/homepage")
    public String homepage(Model model){
        return "homepage";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/{id}")
    public String deleteBuyer(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/usersDisplay";
    }
}

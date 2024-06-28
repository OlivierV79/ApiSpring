package fr.simplon.api.Controllers;

import fr.simplon.api.Models.User;
import fr.simplon.api.Repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.Optional;

@RestController
@RequestMapping("/api/")

public class LoginController {

    // @Autowired
    private final UserRepository userRepository; // final si on utlise pas // @Autowired

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User createUser(@ModelAttribute("username") String username,
                           @ModelAttribute("password") String password,
                           @ModelAttribute("passwordConfirm") String passwordConfirm,
                           @ModelAttribute("email") String email) {

        if (password.equals(passwordConfirm)) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } else {
            throw new InputMismatchException("les mdp ne corespondent pas");
        }
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("username") String username,
                            @ModelAttribute("password") String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "gagné";

        } else
            throw new InputMismatchException("id ou mdp incorrect");

    }
}



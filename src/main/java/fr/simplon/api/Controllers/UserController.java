package fr.simplon.api.Controllers;


import fr.simplon.api.Models.User;
import fr.simplon.api.Repositoy.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/")
public class UserController {


    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@ModelAttribute User user) {
        User newUser = new User(user.getUsername());
        return userRepository.save(newUser);
    }

    @GetMapping("/id/{userId}")
    public Optional<User> getAllUsers(@PathVariable Integer userId) {
        return userRepository.findById(userId);
    }

    @GetMapping("/username/{username}")
    public Optional<User> getAllUsers(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }
}
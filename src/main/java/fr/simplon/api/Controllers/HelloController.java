package fr.simplon.api.Controllers;

import fr.simplon.api.Repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/")
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{username}")
    public String hello(@PathVariable String username) {
        return "Hello, " + username + " ça farte ! On est en Java.";
    }

    @GetMapping("/")
    public String hello(){
        return "Hello !";
    }
}

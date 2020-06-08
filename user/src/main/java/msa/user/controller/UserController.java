package msa.user.controller;

import lombok.AllArgsConstructor;
import msa.user.model.User;
import msa.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.findByUserId(id);
    }
}

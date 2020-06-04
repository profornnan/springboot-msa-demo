package msa.user.controller;

import msa.user.model.User;
import msa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.findByUserId(id);
    }
}

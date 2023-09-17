package com.homeproject.homeproject.api;

import com.homeproject.homeproject.entity.User;
import com.homeproject.homeproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);

    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    @ResponseBody
    public ResponseEntity<?> getUserbyId(@RequestParam String id) {
        Optional<User> resultSet = userService.findUserbyId(id);
        if (resultSet.isPresent())
            return ResponseEntity.ok(resultSet);
        return ResponseEntity.badRequest().body("Some internal server error");
    }

    @GetMapping("/get/all-users")
    @ResponseBody
    public ResponseEntity<?> getAllUsers() {
        List<User> resultSet = userService.getAllUsers();
        if (resultSet.isEmpty())
            return ResponseEntity.badRequest().body("Some internal server error");
        return ResponseEntity.ok(resultSet);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addNewUser(@RequestBody User user) {
        LOG.info("Received add request for adding new user to DB {}", user);
        userService.saveUser(user);
        return ResponseEntity.ok("Added user to the DB");
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        LOG.info("Received add request for adding new user to DB {}", user);
        userService.updateUser(user);
        return ResponseEntity.ok("Added user to the DB");
    }
}

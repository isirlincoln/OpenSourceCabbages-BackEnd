package com.osc.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserRepository dao;

    // READ
    @GetMapping("/user")
    public List<User> getUsers() {
        List<User> foundUsers = dao.findAll();
        return foundUsers;
    }

    // UPDATE
    @PutMapping("/user/{id}")
    public ResponseEntity<User> putUser(@PathVariable Integer id, @RequestBody User user) {
        User foundUser = dao.findById(id).orElse(null);
        if (foundUser == null) {
            return ResponseEntity.notFound().header("Message", "User is not found").build();
        } else {
            if (user.getUsername() != null) {
                foundUser.setUsername(user.getUsername());
            }
            if (user.getPassword() != null) {
                foundUser.setPassword(user.getPassword());
            }
            dao.save(foundUser);
        }

        return ResponseEntity.ok(foundUser);
    }

    // DELETE
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Integer id) {
        User foundUser = dao.findById(id).orElse(null);
        if (foundUser == null) {
            return ResponseEntity.notFound().header("Message", "User is not found").build();
        } else {
            dao.delete(foundUser);
        }
        return ResponseEntity.ok().build();
    }

}

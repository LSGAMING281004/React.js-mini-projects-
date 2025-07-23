package com.CrudOperation.fullstack_backend.controller;

import com.CrudOperation.fullstack_backend.exception.UserNotFoundException;
import com.CrudOperation.fullstack_backend.model.User;
import com.CrudOperation.fullstack_backend.repository.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepositoy userRepositoy;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){

        return userRepositoy.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){

        return userRepositoy.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id)
    {
        return userRepositoy.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updteUser(@RequestBody User newUser, @PathVariable Long id ){
        return userRepositoy.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());

                    return userRepositoy.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositoy.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositoy.deleteById(id);
        return "User ID "+id+" has been success.";
    }
}

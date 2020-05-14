package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.User;
import pl.mzlnk.emergencyspotapi.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "", maxAge = 3600)
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> listUser(){
        return userService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Optional<User> getOne(@PathVariable(value = "id") Long id){
        return userService.findOne(id);
    }

    @PostMapping("/signup")
    public void saveUser(@RequestBody UserDto user){
        userService.create(user);
    }

}

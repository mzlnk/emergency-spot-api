package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.model.dto.user.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.User;
import pl.mzlnk.emergencyspotapi.service.UserService;

import java.security.Principal;
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
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Optional<UserDto> findOne(@PathVariable(value = "id") Long id) {
        return userService.findOne(id);
    }

    @PostMapping("/signup")
    public User saveUser(@RequestBody UserDto user) {
        return userService.create(user);
    }

    @GetMapping("/me")
    public Optional<UserDto> getUsername(Principal principal) {
        return Optional.ofNullable(principal)
                .map(Principal::getName)
                .flatMap(userService::findByUsername);
    }


}

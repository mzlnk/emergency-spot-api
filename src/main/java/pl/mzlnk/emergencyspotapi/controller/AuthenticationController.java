package pl.mzlnk.emergencyspotapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.mzlnk.emergencyspotapi.config.jwt.TokenProvider;
import pl.mzlnk.emergencyspotapi.model.dto.user.UserDto;
import pl.mzlnk.emergencyspotapi.model.dto.user.AuthUserDto;
import pl.mzlnk.emergencyspotapi.service.UserService;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserService userService;

    @PostMapping(value = "/generate")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        Long id = userService
                .findByUsername(userDto.getUsername())
                .map(UserDto::getId)
                .orElse(null);

        return ResponseEntity.ok(new AuthUserDto(id, userDto.getUsername(), token));
    }

}

package pl.mzlnk.emergencyspotapi.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mzlnk.emergencyspotapi.model.dto.user.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.HospitalPatient;
import pl.mzlnk.emergencyspotapi.model.entity.Role;
import pl.mzlnk.emergencyspotapi.model.entity.User;
import pl.mzlnk.emergencyspotapi.repository.RoleRepository;
import pl.mzlnk.emergencyspotapi.repository.UserRepository;
import pl.mzlnk.emergencyspotapi.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Logger logger;

    @Override
    public List<UserDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findOne(Long id) {
        return userRepository
                .findById(id)
                .map(UserDto::fromEntity);
    }

    @Override
    public Optional<UserDto> findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .map(UserDto::fromEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User create(UserDto userDto) {
        User user = new User();

        logger.warn("bcrypt: " + (bCryptPasswordEncoder != null ? "not null" : "null"));
        logger.info("userdto: " + userDto.toString());

        Role userRole = roleRepository.findById(2L).orElse(null);

        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setHospitalPatient(
                new HospitalPatient(
                        userDto.getFirstName(),
                        userDto.getLastName(),
                        userDto.getPesel()
                )
        );

        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        getAuthority(user))
                )
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

}

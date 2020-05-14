package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findOne(Long id);

    Optional<User> findByUsername(String username);

    void deleteById(Long id);

    void create(UserDto userDto);

}

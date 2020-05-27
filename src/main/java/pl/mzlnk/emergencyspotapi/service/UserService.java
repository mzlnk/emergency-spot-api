package pl.mzlnk.emergencyspotapi.service;

import pl.mzlnk.emergencyspotapi.model.dto.UserDto;
import pl.mzlnk.emergencyspotapi.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findOne(Long id);

    Optional<UserDto> findByUsername(String username);

    void deleteById(Long id);

    User create(UserDto userDto);

}

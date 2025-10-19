package id.go.bpddiy.social.service;

import java.util.List;

import id.go.bpddiy.social.dto.UserDto;
import id.go.bpddiy.social.model.User.Role;

public interface UserService {
    List<UserDto> getAll();

    UserDto createUser(String username, String email, String password, Role role);

    UserDto updateUser(Long id, String username, String email, String password, Role role);

    UserDto deleteUser(Long id);
}

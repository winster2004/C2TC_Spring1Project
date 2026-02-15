package com.example.wareQr.serviceee;
import java.util.List;

import com.example.wareQr.model.User;

public interface IUserService {

    User addUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
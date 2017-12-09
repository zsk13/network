package network.service;

import network.model.User;
import network.model.Users;

import java.util.List;

public interface UsersService {
    void createUser(Users user);

    void deleteUser(Users user);

    void updateUser(Users user);

    Users findUserById(Integer userId);

}

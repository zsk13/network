package network.service;

import network.model.Users;

public interface UsersService {
    void createUser(Users user);

    void deleteUser(Users user);

    void updateUser(Users user);

    Users findUserById(Long userId);

    void deleteByOpenId(String openId);

    Users findByOpneId(String openId);


    }

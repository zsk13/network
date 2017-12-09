package network.service;

public interface UsersService {
    void createUser(Users user);

    void deleteUser(Users user);

    void updateUser(Users user);

    Users findUserById(Integer userId);

}

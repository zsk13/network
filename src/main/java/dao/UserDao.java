package dao;

import model.User;

import java.util.List;

public interface UserDao {

  List<User> findUserByParams(User user);
  
  User findUserByUserId(String userId);
  
  void createUser(User user);

  void deleteUser(User user);

  void batchDeleteUser(List<Integer> userIds);

  void updateUser(User user);

}

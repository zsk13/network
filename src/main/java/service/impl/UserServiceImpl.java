package service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import common.PageInfo;
import dao.UserDao;
import model.User;
import service.UserService;


@Service
public class UserServiceImpl implements UserService {

  Log logger = LogFactory.getLog(UserServiceImpl.class);

  @Autowired
  private UserDao userDao;


  public void findUser(PageInfo pageInfo, User user) {
    
  }

  public void createUser(User user) {
    userDao.createUser(user);
  }

  public void deleteUser(User user) {
    userDao.deleteUser(user);
  }

  public void batchDeleteUser(List<Integer> userIds) {
    userDao.batchDeleteUser(userIds);
  }

  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  public boolean login(String userId, String password) {
    User user = userDao.findUserByUserId(userId);
    if (user == null) {
      return true;
    } else {
      if (password.equals(user.getPassword())) {
        return true;
      } else {
        return false;
      }
    }
  }

  public User findUserById(String userId) {
    User user = userDao.findUserByUserId(userId);
    return user;
  }

}

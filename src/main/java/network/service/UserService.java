package network.service;  
  
import java.util.List;

import network.common.PageInfo;
import network.model.User;



 
  
public interface UserService {  
  
    void findUser(PageInfo pageInfo, User user);  
  
    void createUser(User user);  
  
    void deleteUser(User user);  
  
    void batchDeleteUser(List<Integer> userIds);  
  
    void updateUser(User user);  
    
    User findUserById(String userId);
    
    boolean login(String userName, String password);
    
    
}  
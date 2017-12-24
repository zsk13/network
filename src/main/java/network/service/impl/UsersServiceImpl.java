package network.service.impl;

import network.dao.UsersDao;
import network.model.Users;
import network.model.UsersExample;
import network.service.UsersService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class UsersServiceImpl implements UsersService {
    Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private UsersDao usersDao;

    public void createUser(Users user) {
        usersDao.insert(user);
    }

    public void deleteUser(Users user) {
        usersDao.deleteByPrimaryKey(user.getuId());
    }

    public void updateUser(Users user) {
        usersDao.updateByPrimaryKey(user);
    }

    public Users findUserById(Long userId) {
        Users user = usersDao.selectByPrimaryKey(userId);
        return user;
    }
    public void deleteByOpenId(String openId){
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUOpenIdEqualTo(openId);
        usersDao.deleteByExample(usersExample);
    }


}

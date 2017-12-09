package network.service.impl;

import network.dao.UsersDao;
import network.model.Users;
import network.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;

public class FollowServiceImpl implements FollowService{
    @Autowired
    private UsersDao usersDao;

    public void follow(String content) {
        int index = content.indexOf(",");
        String sno = content.substring(3, index);
        String name = content.substring(index + 4);
        Users users = new Users();
        users.setSno(sno);
        users.setName(name);
        usersDao.insert(users);
    }
}

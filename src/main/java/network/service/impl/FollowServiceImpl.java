package network.service.impl;

import network.dao.UsersDao;
import network.model.Users;
import network.service.FollowService;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    @Override
    public void follow(Map<String, String> map, PrintWriter out, String content) {
        String fromUserName = map.get("FromUserName");
        int index = content.indexOf(",");
        String sno = content.substring(3, index);
        String name = content.substring(index + 4);
        Users users = new Users();
        users.setuOpenId(fromUserName);
        users.setSno(sno);
        users.setName(name);
        usersDao.insert(users);
    }
}

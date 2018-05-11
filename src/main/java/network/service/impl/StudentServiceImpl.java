package network.service.impl;

import network.dao.UsersDao;
import network.model.Users;
import network.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private UsersDao usersDao;

    public int addStudent(Users users) {
        Users u = usersDao.selectByOpenId(users.getuOpenId());
        if (u != null)
            return 2;
        usersDao.insert(users);
        return 1;
    }
}

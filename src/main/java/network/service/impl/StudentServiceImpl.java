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

    public void addStudent(Users users) {
        usersDao.insert(users);
    }
}

package network.service.impl;

import network.dao.AdminDao;
import network.model.Admin;
import network.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AdminDao adminDao;
    public boolean check(String name, String password) {
        // TODO Auto-generated method stub
        Admin admin;
        admin = adminDao.selectByname(name);
        if(admin!= null && admin.getPassword().equals(password))
            return true;
        else return false;
    }
}

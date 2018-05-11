package network.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network.dao.AdminDao;
import network.model.Admin;
import network.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
@Autowired
private AdminDao adminDao;
	public boolean check(String name, String password) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin = adminDao.selectByname(name);
		if(admin!= null && admin.getPassword().equals(password))
			return true;
		else return false;
	}

}

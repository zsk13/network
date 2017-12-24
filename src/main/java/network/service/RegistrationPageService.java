package network.service;

import com.github.pagehelper.PageInfo;
import network.model.Registration;

public interface RegistrationPageService {
    PageInfo<Registration> queryByPage(Long tId,Integer pageNo, Integer pageSize);
}

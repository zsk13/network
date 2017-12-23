package network.service;

import com.github.pagehelper.PageInfo;
import network.model.Registration;

public interface RegistrationPageService {
    PageInfo<Registration> queryByPage(Integer pageNo, Integer pageSize);
}

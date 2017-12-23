package network.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import network.dao.RegistrationDao;
import network.model.Registration;
import network.service.RegistrationPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationPageServiceImpl implements RegistrationPageService{
    @Autowired
    private RegistrationDao registrationDao;
    public  PageInfo<Registration> queryByPage(Integer pageNo, Integer pageSize){
        System.out.println("into queryByPage!");
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Registration> list = registrationDao.getAll();
        //用PageInfo对结果进行包装
        PageInfo<Registration> page = new PageInfo<Registration>(list);
        return page;
    }


}

package network.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import network.dao.LocationDao;
import network.model.Location;
import network.service.LocationPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationPageServiceImpl implements LocationPageService{
    @Autowired
    private LocationDao locationDao;
    public PageInfo<Location> queryByPage(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Location> list = locationDao.getAll();
        //用PageInfo对结果进行包装
        PageInfo<Location> page = new PageInfo<Location>(list);
        return page;
    }


}

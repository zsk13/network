package network.service;

import com.github.pagehelper.PageInfo;
import network.model.Location;

public interface LocationPageService {
    PageInfo<Location> queryByPage(Integer pageNo, Integer pageSize);

}

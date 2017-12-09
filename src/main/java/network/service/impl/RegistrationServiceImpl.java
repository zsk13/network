package network.service.impl;

import network.dao.LocationDao;
import network.dao.RegistrationDao;
import network.dao.UsersDao;
import network.model.Location;
import network.model.Registration;
import network.model.Rollcall;
import network.model.Users;
import network.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private LocationDao locationDao;
    public int registration(double location_x, double location_y, String openId, Date time){
      int code = 0;
      Users users = usersDao.selectByOpenId(openId);
      Registration registration = registrationDao.selectByClass(users.getClassname(),time);
        if(registration==null){
            code = 1;
        return code;
        }
      Location location = this.locationDao.selectByPrimaryKey(registration.getlId());
      if(location_x<location.getMinLcationX() || location_x>location.getMaxLcationX() || location_y<location.getMinLcationY() || location_y>location.getMaxLocationY())
      {
          code = 2;
      return  code;
      }else {
          Rollcall rollcall = new Rollcall();
          rollcall.setLocationX(location_x);
          rollcall.setLocationY(location_y);
          rollcall.setrId(registration.getrId());
          rollcall.setuId(users.getuId());
          rollcall.setrTime(time);
          code = 3;
      }

        return code;
    }


}

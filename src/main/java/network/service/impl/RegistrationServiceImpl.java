package network.service.impl;

import network.dao.LocationDao;
import network.dao.RegistrationDao;
import network.dao.RollcallDao;
import network.dao.UsersDao;
import network.model.Location;
import network.model.Registration;
import network.model.Rollcall;
import network.model.Users;
import network.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private RollcallDao rollcallDao;

    public int registration(Long rId, double location_x, double location_y, String openId, Date time) {
        int code = 0;
        if (rId == null)
            return 1;
        Users users = usersDao.selectByOpenId(openId);
        if (users == null)
            return 0;
        Registration registration = new Registration();
        registration = registrationDao.checkIsSelected(rId, users.getuId());
        if (registration == null) {
            code = 1;
            return code;
        }
        Rollcall test = rollcallDao.check(users.getuId(), registration.getrId());
        if (test != null) {
            code = 4;
            return code;
        }
        Location location = this.locationDao.selectByPrimaryKey(registration.getlId());
        if (location_x < location.getMinLcationX() || location_x > location.getMaxLcationX() || location_y < location.getMinLcationY() || location_y > location.getMaxLocationY()) {
            code = 2;
            return code;
        } else {
            Rollcall rollcall = new Rollcall();
            rollcall.setLocationX(location_x);
            rollcall.setLocationY(location_y);
            rollcall.setLocationName(location.getLocationName());
            rollcall.setrId(registration.getrId());
            rollcall.setuId(users.getuId());
            rollcall.setrTime(time);
            rollcallDao.insertSelective(rollcall);
            code = 3;
        }

        return code;
    }

    public void add(Registration registration) {
        registrationDao.insertSelective(registration);
    }

    public List<Registration> getAll() {
        return registrationDao.getAll();
    }

    public List<Registration> getByOpenid(String openId) {
        List<Registration> registrationList = new ArrayList<Registration>();
        Users users = usersDao.selectByOpenId(openId);
        if(users == null)
            return registrationList;
        registrationList = registrationDao.selectByUid(users.getuId());
        return registrationList;
    }


	public List<Registration> getByCourseId(Long cId) {
		return registrationDao.getByCourseId(cId);
	}

}

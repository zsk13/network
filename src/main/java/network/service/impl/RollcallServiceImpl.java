package network.service.impl;

import network.dao.RollcallDao;
import network.dao.UsersDao;
import network.model.Rollcall;
import network.model.RollcallDisplay;
import network.model.RollcallExport;
import network.model.Users;
import network.service.RollcallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RollcallServiceImpl implements RollcallService {

    @Autowired
    private RollcallDao rollcallDao;
    @Autowired
    private UsersDao usersDao;

    public List<Rollcall> getAll() {
        return rollcallDao.getAll();
    }

    public List<Rollcall> getByRegistrationId(Long rid) {
        return rollcallDao.getByRegistrationId(rid);
    }

    public List<RollcallDisplay> getAllRollcallDisplays() {
        return rollcallDao.getAllRollcallDisplays();
    }

    public List<RollcallDisplay> getAllRollcallDisplaysByRegistrationId(Long rid) {
        return rollcallDao.getAllRollcallDisplaysByRegistrationId(rid);
    }

    public List<RollcallExport> getRegistration(Long rId) {
        List<Users> studentList = usersDao.selectAllStudent(rId);
        List<Users> registrationList = usersDao.selectAllRegistration(rId);
        List<RollcallExport> rollcallExportList = new ArrayList<RollcallExport>();
        Map<String, String> registrationMap = new HashMap<String, String>();

        for (Users users : registrationList) {
            RollcallExport rollcallExport = new RollcallExport();
            rollcallExport.setSno(users.getSno());
            rollcallExport.setName(users.getName());
            rollcallExport.setIsRegistered(1);
            rollcallExportList.add(rollcallExport);
            registrationMap.put(users.getSno(),"");
        }
        for (Users users : studentList) {
            RollcallExport rollcallExport = new RollcallExport();
            if (!registrationMap.containsKey(users.getSno())) {
                rollcallExport.setSno(users.getSno());
                rollcallExport.setName(users.getName());
                rollcallExport.setIsRegistered(0);
                rollcallExportList.add(rollcallExport);
            }
        }
        return rollcallExportList;
    }

}

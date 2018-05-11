package network.service.impl;

import network.dao.UsersDao;
import network.model.RollcallExport;
import network.model.User;
import network.model.Users;
import network.service.RollcallExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RollcallExportServiceImpl implements RollcallExportService{
    @Autowired
    private UsersDao usersDao;
    public List<Map<String, String>> selectAllRollCall(Long rId){
        List<Map<String, String>> mapList=new ArrayList<Map<String,String>>();
        List<Users> studentList = usersDao.selectAllStudent(rId);
        List<Users> registrationList = usersDao.selectAllRegistration(rId);
        Map<String,String> registrationMap = new HashMap<String,String>();
        for(Users users:registrationList){
            registrationMap.put(users.getSno(),"");
        }
        for(Users users:studentList){
            Map<String, String> map=new HashMap<String, String>();
            map.put("学号",users.getSno());
            map.put("姓名",users.getName());

            if(registrationMap.containsKey(users.getSno()))
                map.put("是否签到","是");
            else
                map.put("是否签到","否");
            mapList.add(map);

        }
                 return mapList;
    }


}

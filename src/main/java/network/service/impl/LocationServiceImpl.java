package network.service.impl;

import network.dao.LocationDao;
import network.model.Location;
import network.service.LocationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationDao locationDao;
    public void add(Location location){
        locationDao.insertSelective(location);

    }
	@Override
	public List<Location> getAll() {
		return locationDao.getAll();
	}
    public void delete(Long lId){
        locationDao.deleteByPrimaryKey(lId);
    }
}

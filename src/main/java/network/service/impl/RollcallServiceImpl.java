package network.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network.dao.RollcallDao;
import network.model.Rollcall;
import network.model.RollcallDisplay;
import network.service.RollcallService;

@Service
public class RollcallServiceImpl implements RollcallService{

	@Autowired
	private RollcallDao rollcallDao;
	
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

}

package network.service;

import network.model.Rollcall;
import network.model.RollcallDisplay;

import java.util.List;

public interface RollcallService {
	public List<Rollcall> getAll();
	public List<Rollcall> getByRegistrationId(Long rid);
	
	public List<RollcallDisplay> getAllRollcallDisplays();
	public List<RollcallDisplay> getAllRollcallDisplaysByRegistrationId(Long rid);
}

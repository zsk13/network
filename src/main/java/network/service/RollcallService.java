package network.service;

import network.model.Rollcall;
import network.model.RollcallDisplay;
import network.model.RollcallExport;

import java.util.List;

public interface RollcallService {
	public List<Rollcall> getAll();
	public List<Rollcall> getByRegistrationId(Long rid);
	
	public List<RollcallDisplay> getAllRollcallDisplays();
	public List<RollcallDisplay> getAllRollcallDisplaysByRegistrationId(Long rid);

	public List<RollcallExport> getRegistration(Long rId);
	
	public Rollcall getRegistrationByRidAndUid(Long rId,Long uId);
}

package network.service;

import java.util.List;

import network.model.Location;

public interface LocationService {
    public void add(Location location);
    public List<Location> getAll();
    public void delete(Long lId);
}

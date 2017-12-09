package network.service;

import java.util.Date;

public interface RegistrationService {
    public int registration(double location_x, double location_y, String openId, Date time);
}

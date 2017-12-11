package network.service;

import network.model.Registration;

import java.util.Date;

public interface RegistrationService {
    public int registration(double location_x, double location_y, String openId, Date time);
    public void add(Registration registration);
}

package network.service;

import network.model.Course;
import network.model.Registration;

import java.util.Date;
import java.util.List;

public interface RegistrationService {
    public int registration(Long rId,double location_x, double location_y, String openId, Date time);
    public void add(Registration registration);
    public List<Registration> getAll();
    public List<Registration> getByCourseId(Long cId);
    public List<Registration> getByOpenid(String openid);
    public List<Course> getAllCourses();
    public List<Course> getValidCoursesByTeacherId(long tId);
    public void deleteById(long rId);
}

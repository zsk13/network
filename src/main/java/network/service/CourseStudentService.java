package network.service;

import network.model.Course;
import network.model.CourseStudent;

import java.util.List;

public interface CourseStudentService {
    public List<Course> getAllSelectiveCourses();

    public boolean checkPassword(Long cId, String password);

    public int addCourseStudent(CourseStudent courseStudent);

    public List<Course> getAllSelected(Long uId);

    public List<Course> getAllNoSelected(Long uId);

    public void delete(Long uId,Long cId);
}

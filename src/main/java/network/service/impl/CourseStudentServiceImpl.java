package network.service.impl;

import network.dao.CourseMapper;
import network.dao.CourseStudentMapper;
import network.model.Course;
import network.model.CourseStudent;
import network.model.CourseStudentExample;
import network.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    private CourseStudentMapper courseStudentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllSelectiveCourses() {
        List<Course> list = new ArrayList<>();
        for (Course course : courseMapper.getAll()) {
            if (course.getcState() == 1)
                list.add(course);
        }
        return list;
    }

    @Override
    public boolean checkPassword(Long cId, String password) {
        Course course = courseMapper.selectByPrimaryKey(cId);
        return course.getcPassword().equals(password);
    }

    @Override
    public int addCourseStudent(CourseStudent courseStudent) {
        return courseStudentMapper.insert(courseStudent);
    }

    public List<Course> getAllSelected(Long uId) {
        List<Course> list = new ArrayList<>();
        for (Course course : courseMapper.getAllSelected(uId)) {
            if (course.getcState() == 1)
                list.add(course);
        }
        return list;
    }

    public List<Course> getAllNoSelected(Long uId) {
        List<Course> list = new ArrayList<>();
        for (Course course : courseMapper.getAllNoSelected(uId)) {
            if (course.getcState() == 1)
                list.add(course);
        }
        return list;

    }
    public void delete(Long uId,Long cId){
        CourseStudentExample courseStudentExample = new CourseStudentExample();
        CourseStudentExample.Criteria criteria = courseStudentExample.createCriteria();
        criteria.andCIdEqualTo(cId);
        criteria.andSIdEqualTo(uId);
        courseStudentMapper.deleteByExample(courseStudentExample);
    }
}

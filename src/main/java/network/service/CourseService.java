package network.service;

import java.util.List;

import network.model.Course;

public interface CourseService {
    int insert(Course record);
    int deleteByPrimaryKey(Long cId);
    int updateByPrimaryKey(Course record);
    Course getCourse(Long cid);
}

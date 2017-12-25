package network.service;

import network.model.Course;

public interface CourseService {
    int insert(Course record);
    int deleteByPrimaryKey(Long cId);
    int updateByPrimaryKey(Course record);
}

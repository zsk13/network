package network.service.impl;

import network.dao.CourseMapper;
import network.model.Course;
import network.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseMapper courseMapper;

    @Override
    public int insert(Course record) {
        return courseMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Long cId) {
        return courseMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public int updateByPrimaryKey(Course record) {
        return courseMapper.updateByPrimaryKey(record);
    }

    @Override
    public Course getCourse(Long cid) {
        return courseMapper.selectByPrimaryKey(cid);
    }
}

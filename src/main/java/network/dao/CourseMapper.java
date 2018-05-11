package network.dao;

import java.util.List;
import network.model.Course;
import network.model.CourseExample;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Long cId);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);
    
    List<Course> getAll();
    
    List<Course> getValidCoursesByTeacherId(long tId);

    Course selectByPrimaryKey(Long cId);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getAllSelected(@Param("uId") Long uId);

    List<Course> getAllNoSelected(@Param("uId")Long uId);

}
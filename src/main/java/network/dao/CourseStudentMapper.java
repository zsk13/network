package network.dao;

import java.util.List;
import network.model.CourseStudent;
import network.model.CourseStudentExample;
import org.apache.ibatis.annotations.Param;

public interface CourseStudentMapper {
    int countByExample(CourseStudentExample example);

    int deleteByExample(CourseStudentExample example);

    int deleteByPrimaryKey(Long csId);

    int insert(CourseStudent record);

    int insertSelective(CourseStudent record);

    List<CourseStudent> selectByExample(CourseStudentExample example);

    CourseStudent selectByPrimaryKey(Long csId);

    int updateByExampleSelective(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    int updateByExample(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    int updateByPrimaryKeySelective(CourseStudent record);

    int updateByPrimaryKey(CourseStudent record);
}
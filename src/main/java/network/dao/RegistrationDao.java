package network.dao;

import java.util.List;

import network.model.Course;
import network.model.Registration;
import network.model.RegistrationExample;
import org.apache.ibatis.annotations.Param;

public interface RegistrationDao {
    int countByExample(RegistrationExample example);

    int deleteByExample(RegistrationExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(Registration record);

    int insertSelective(Registration record);

    List<Registration> selectByExample(RegistrationExample example);

    
    List<Registration> getAll();
    List<Registration> getByCourseId(long cId);
    void deleteById(long rId);
    
    Registration selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);

    List<Registration> selectByUid(Long uId);

    Registration checkIsSelected(@Param("rId") Long rId,@Param("uId") Long uId);

    List<Registration> selectByTeacher(@Param("tId") Long tId);

}
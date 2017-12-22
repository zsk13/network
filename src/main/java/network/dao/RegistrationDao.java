package network.dao;

import java.util.Date;
import java.util.List;
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
    List<Registration> getByCourseId(Long cId);

    Registration selectByPrimaryKey(Long rId);

    Registration selectByClass(@Param("className")String className,@Param("time")Date time);

    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);
}
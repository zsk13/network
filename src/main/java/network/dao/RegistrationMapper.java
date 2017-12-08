package network.dao;

import java.util.List;
import network.model.Registration;
import network.model.RegistrationExample;
import org.apache.ibatis.annotations.Param;

public interface RegistrationMapper {
    int countByExample(RegistrationExample example);

    int deleteByExample(RegistrationExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(Registration record);

    int insertSelective(Registration record);

    List<Registration> selectByExample(RegistrationExample example);

    Registration selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByExample(@Param("record") Registration record, @Param("example") RegistrationExample example);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);
}
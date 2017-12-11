package network.dao;

import java.util.List;
import network.model.Users;
import network.model.UsersExample;
import org.apache.ibatis.annotations.Param;

public interface UsersDao {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Long uId);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Long uId);

    Users selectByOpenId(@Param("uOpenId")String uOpenId);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}
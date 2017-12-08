package network.dao;

import java.util.List;
import network.model.Rollcall;
import network.model.RollcallExample;
import org.apache.ibatis.annotations.Param;

public interface RollcallMapper {
    int countByExample(RollcallExample example);

    int deleteByExample(RollcallExample example);

    int deleteByPrimaryKey(Long rcId);

    int insert(Rollcall record);

    int insertSelective(Rollcall record);

    List<Rollcall> selectByExample(RollcallExample example);

    Rollcall selectByPrimaryKey(Long rcId);

    int updateByExampleSelective(@Param("record") Rollcall record, @Param("example") RollcallExample example);

    int updateByExample(@Param("record") Rollcall record, @Param("example") RollcallExample example);

    int updateByPrimaryKeySelective(Rollcall record);

    int updateByPrimaryKey(Rollcall record);
}
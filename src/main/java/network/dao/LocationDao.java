package network.dao;

import java.util.List;
import network.model.Location;
import network.model.LocationExample;
import org.apache.ibatis.annotations.Param;

public interface LocationDao {
    int countByExample(LocationExample example);

    int deleteByExample(LocationExample example);

    int deleteByPrimaryKey(Long lId);

    int insert(Location record);

    int insertSelective(Location record);

    List<Location> selectByExample(LocationExample example);

    Location selectByPrimaryKey(Long lId);

    Location selectByName(String name);

    int updateByExampleSelective(@Param("record") Location record, @Param("example") LocationExample example);

    int updateByExample(@Param("record") Location record, @Param("example") LocationExample example);

    int updateByPrimaryKeySelective(Location record);

    int updateByPrimaryKey(Location record);

	List<Location> getAll();
}
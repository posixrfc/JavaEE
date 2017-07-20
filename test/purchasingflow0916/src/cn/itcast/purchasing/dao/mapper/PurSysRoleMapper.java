package cn.itcast.purchasing.dao.mapper;

import cn.itcast.purchasing.po.PurSysRole;
import cn.itcast.purchasing.po.PurSysRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurSysRoleMapper {
    int countByExample(PurSysRoleExample example);

    int deleteByExample(PurSysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSysRole record);

    int insertSelective(PurSysRole record);

    List<PurSysRole> selectByExample(PurSysRoleExample example);

    PurSysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSysRole record, @Param("example") PurSysRoleExample example);

    int updateByExample(@Param("record") PurSysRole record, @Param("example") PurSysRoleExample example);

    int updateByPrimaryKeySelective(PurSysRole record);

    int updateByPrimaryKey(PurSysRole record);
}
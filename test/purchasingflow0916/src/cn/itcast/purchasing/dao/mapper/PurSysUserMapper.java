package cn.itcast.purchasing.dao.mapper;

import cn.itcast.purchasing.po.PurSysUser;
import cn.itcast.purchasing.po.PurSysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurSysUserMapper {
    int countByExample(PurSysUserExample example);

    int deleteByExample(PurSysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSysUser record);

    int insertSelective(PurSysUser record);

    List<PurSysUser> selectByExample(PurSysUserExample example);

    PurSysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSysUser record, @Param("example") PurSysUserExample example);

    int updateByExample(@Param("record") PurSysUser record, @Param("example") PurSysUserExample example);

    int updateByPrimaryKeySelective(PurSysUser record);

    int updateByPrimaryKey(PurSysUser record);
}
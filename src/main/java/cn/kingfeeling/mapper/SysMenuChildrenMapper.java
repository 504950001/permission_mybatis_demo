package cn.kingfeeling.mapper;

import cn.kingfeeling.model.SysMenuChildren;
import cn.kingfeeling.model.SysMenuChildrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuChildrenMapper {
    long countByExample(SysMenuChildrenExample example);

    int deleteByExample(SysMenuChildrenExample example);

    int insert(SysMenuChildren record);

    int insertSelective(SysMenuChildren record);

    List<SysMenuChildren> selectByExample(SysMenuChildrenExample example);

    int updateByExampleSelective(@Param("record") SysMenuChildren record, @Param("example") SysMenuChildrenExample example);

    int updateByExample(@Param("record") SysMenuChildren record, @Param("example") SysMenuChildrenExample example);
}
package cn.kingfeeling.mapper;

import cn.kingfeeling.model.SysDepartmentChildren;
import cn.kingfeeling.model.SysDepartmentChildrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDepartmentChildrenMapper {
    long countByExample(SysDepartmentChildrenExample example);

    int deleteByExample(SysDepartmentChildrenExample example);

    int insert(SysDepartmentChildren record);

    int insertSelective(SysDepartmentChildren record);

    List<SysDepartmentChildren> selectByExample(SysDepartmentChildrenExample example);

    int updateByExampleSelective(@Param("record") SysDepartmentChildren record, @Param("example") SysDepartmentChildrenExample example);

    int updateByExample(@Param("record") SysDepartmentChildren record, @Param("example") SysDepartmentChildrenExample example);
}
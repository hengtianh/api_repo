package org.easy.develop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.easy.develop.common.domain.DevApi;
import org.easy.develop.common.domain.DevApiExample;

public interface DevApiMapper {
    long countByExample(DevApiExample example);

    int deleteByExample(DevApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DevApi record);

    int insertSelective(DevApi record);

    List<DevApi> selectByExample(DevApiExample example);

    DevApi selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DevApi record, @Param("example") DevApiExample example);

    int updateByExample(@Param("record") DevApi record, @Param("example") DevApiExample example);

    int updateByPrimaryKeySelective(DevApi record);

    int updateByPrimaryKey(DevApi record);
}
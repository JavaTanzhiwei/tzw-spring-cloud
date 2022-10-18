package com.springcloud.study.system.mapper;

import com.springcloud.study.api.system.bean.po.SysDictData;
import com.springcloud.study.mybatis.core.mapper.BaseMapperPlus;
import com.springcloud.study.system.bean.vo.SysDictDataVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 类 描 述: 字典数据 数据层
 * 作   者: 谭志伟
 * 时   间: 2022/10/14  10:35
 */
public interface SysDictDataMapper extends BaseMapperPlus<SysDictDataMapper, SysDictData, SysDictDataVo> {

    /**
     * 方法描述: 查询字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:24
     */
    @Select("select count(1) from sys_dict_data where dict_type=#{dictType}")
    int countDictDataByType(String dictType);

    /**
     * 方法描述: 同步修改字典类型
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:30
     */
    @Update("update sys_dict_data set dict_type = #{newDictType} where dict_type = #{oldDictType}")
    int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    /**
     * 方法描述: 根据字典类型查询字典数据
     * 作   者: 谭志伟
     * 时   间: 2022/10/18 14:31
     */
    @Select("select * from sys_dict_data where status = '0' and dict_type = #{dictType} order by dict_sort asc")
    List<SysDictData> selectDictDataByType(String dictType);
}

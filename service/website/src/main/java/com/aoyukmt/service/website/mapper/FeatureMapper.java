package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.entity.Feature;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @InterfaceName：FeatureMapper
 * @Author: aoyu
 * @Date: 2025/3/6 下午5:10
 * @Description:
 */

@Mapper
public interface FeatureMapper {

    /*
        查询所有功能特点
     */
    @Select("select * from features where is_active = 1")
    List<Feature> selectAllFeature();

}

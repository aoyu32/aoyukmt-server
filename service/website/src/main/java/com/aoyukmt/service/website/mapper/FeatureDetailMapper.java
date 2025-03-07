package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.entity.FeatureDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @InterfaceName：FeatureDetailMapper
 * @Author: aoyu
 * @Date: 2025/3/7 上午11:56
 * @Description:
 */

@Mapper
public interface FeatureDetailMapper {
    /*
     *查询所有功能详情
     */
    @Select("select * from feature_detail where is_active = 1 order by sort_order asc")
    List<FeatureDetail> selectAllFeatureDetail();

}

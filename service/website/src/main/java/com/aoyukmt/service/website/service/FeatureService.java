package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.resp.FeatureCardVO;

import java.util.List;

/**
 * @InterfaceName：FeatureService
 * @Author: aoyu
 * @Date: 2025/3/6 下午5:07
 * @Description:功能特点业务层接口
 */

public interface FeatureService {
    /*
        查询所有功能特点
     */
    List<FeatureCardVO> getAllFeature();
}

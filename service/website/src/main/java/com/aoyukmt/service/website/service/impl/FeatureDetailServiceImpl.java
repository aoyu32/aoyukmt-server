package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.entity.FeatureDetail;
import com.aoyukmt.model.vo.resp.FeatureDetailCardVO;
import com.aoyukmt.service.website.mapper.FeatureDetailMapper;
import com.aoyukmt.service.website.service.FeatureDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：FeatureDetailServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-07 11:53
 * @Description: 功能详情展示接口实现类
 */

@Service
public class FeatureDetailServiceImpl implements FeatureDetailService {

    private static final Logger log = LoggerFactory.getLogger(FeatureDetailServiceImpl.class);
    @Autowired
    private FeatureDetailMapper featureDetailMapper;

    /**
     * 获取所有功能详情展示列表
     *
     * @return 功能详情列表
     */
    @Override
    public List<FeatureDetailCardVO> getAllFeatureDetail() {
        log.info("查询所有功能展示详情列表...");
        List<FeatureDetail> featureDetails = featureDetailMapper.selectAllFeatureDetail();
        return featureDetails.stream().map(featureDetail -> {
            FeatureDetailCardVO featureCardVO = new FeatureDetailCardVO();
            BeanUtils.copyProperties(featureDetail, featureCardVO);
            return featureCardVO;
        }).toList();
    }
}

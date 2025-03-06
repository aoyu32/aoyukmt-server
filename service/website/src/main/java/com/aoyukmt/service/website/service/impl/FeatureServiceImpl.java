package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.entity.Feature;
import com.aoyukmt.model.vo.FeatureVo;
import com.aoyukmt.service.website.mapper.FeatureMapper;
import com.aoyukmt.service.website.service.FeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：FeatureServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-06 17:09
 * @Description: 功能特点列表业务层接口实现类
 */

@Service
public class FeatureServiceImpl implements FeatureService {

    private static final Logger log = LoggerFactory.getLogger(FeatureServiceImpl.class);
    @Autowired
    private FeatureMapper featureMapper;

    @Override
    public List<FeatureVo> queryAllFeature() {
        log.info("查询所有功能列表...");
        List<Feature> features = featureMapper.selectAllFeature();
        List<FeatureVo> featureVos = new ArrayList<>();
        for (Feature feature : features) {
            FeatureVo featureVo = new FeatureVo();
            BeanUtils.copyProperties(feature,featureVo);
            featureVos.add(featureVo);
        }
        return featureVos;
    }
}

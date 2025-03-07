package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.FeatureDetailCardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @InterfaceName：FeatureDetailService
 * @Author: aoyu
 * @Date: 2025/3/7 上午11:52
 * @Description:
 */

public interface FeatureDetailService {
    /*
     * 查询所有功能详情展示列表
     */
    List<FeatureDetailCardVO> getAllFeatureDetail();

}

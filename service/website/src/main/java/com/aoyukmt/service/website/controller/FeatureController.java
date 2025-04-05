package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.vo.resp.FeatureCardVO;
import com.aoyukmt.service.website.service.FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName：FeatureController
 * @Author: aoyu
 * @Date: 2025-03-06 17:00
 * @Description: 主页功能特点列表控制器
 */
@RestController
@RequestMapping("/web/feature")
@Tag(name = "功能特点",description = "官网主页功能特点列表")
public class FeatureController {

    private static final Logger log = LoggerFactory.getLogger(FeatureController.class);
    @Autowired
    private FeatureService featureService;

    /**
     * @description: 查询所有功能特点
     * @author: aoyu
     * @date: 2025/3/6 下午5:23
     * @param:
     * @return: 功能特点列表
     */
    @Operation(summary = "获取功能特点列表", description = "获取官网主页展示的功能特点列表数据")
    @GetMapping(value = "/list" ,produces = "application/json")
    public Result<List<FeatureCardVO>> getAllFeature() {
        log.info("请求获取所有功能特点列表...");
        List<FeatureCardVO> allFeature = featureService.getAllFeature();
        log.info("所有功能特点列表总数：{}，功能特点列表数据：{}",allFeature.size(),allFeature);
        return Result.success(allFeature);
    }

}

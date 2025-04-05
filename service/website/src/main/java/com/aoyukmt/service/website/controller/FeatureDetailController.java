package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.AliYunOSSUtils;
import com.aoyukmt.model.vo.resp.FeatureDetailCardVO;
import com.aoyukmt.service.website.service.FeatureDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName：DetailController
 * @Author: aoyu
 * @Date: 2025-03-07 10:40
 * @Description: 主页功能详情展示控制类
 */


@Tag(name = "功能展示", description = "官网主页功能详情展示接口")
@RestController
@RequestMapping("/web/detail")
public class FeatureDetailController {

    private static final Logger log = LoggerFactory.getLogger(FeatureDetailController.class);
    @Autowired
    private FeatureDetailService featureDetailService;

    @Autowired
    private AliYunOSSUtils aliyunOSSUtils;

    /**
     * @description: 获取所有功能详情展示列表接口
     * @author: aoyu
     * @date: 2025/3/7 下午12:29
     * @param:
     * @return: 功能详情展示列表
     */
    @Operation(summary = "功能详情展示列表", description = "官网主页功能详情展示列表接口")
    @GetMapping("/list")
    public Result<List<FeatureDetailCardVO>> queryAllFeatureDetail() {
        log.info("获取所有功能展示列表...");
        List<FeatureDetailCardVO> allFeatureDetail = featureDetailService.getAllFeatureDetail();
        log.info("所有功能详情展示列表总数:{},功能详情展示数据:{}", allFeatureDetail.size(), allFeatureDetail);
        return Result.success(allFeatureDetail);
    }

    @Operation(summary = "上传详情展示图片", description = "官网主页功能详情展示列表图片上传接口")
    @PostMapping("/img")
    public Result<?> uploadDetailImage(MultipartFile file) throws IOException {
        log.info("文件名：{}", file.getOriginalFilename());
        String filePath = aliyunOSSUtils.uploadFile(file.getBytes(), file.getOriginalFilename());
        log.info("上传图片：{}", filePath);
        return Result.success("上传成功");
    }

}

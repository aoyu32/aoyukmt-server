package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.dto.DocumentWithCategoryDTO;
import com.aoyukmt.service.website.service.DocumentService;
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
 * @ClassName：DocumentController
 * @Author: aoyu
 * @Date: 2025-03-08 16:17
 * @Description: 使用文档控制器类
 */

@RestController
@RequestMapping("/web/docs")
@Tag(name = "使用文档",description = "使用文档接口")
public class DocumentController {

    private static final Logger log = LoggerFactory.getLogger(DocumentController.class);
    @Autowired
    private DocumentService documentService;

    /**
     * @description: 获取所有分类下的所有文档信息
     * @author: aoyu
     * @date: 2025/3/8 下午5:56
     * @param:
     * @return: 所有分类和文档
     */
    @Operation(summary = "获取所有分类下所有文档",description = "获取所有文档分类下的所有文档")
    @GetMapping("list")
    public Result<List<DocumentWithCategoryDTO>> getAllCategoryWithDocument() {
        log.info("请求获取所有文档分类下的所有文档...");
        List<DocumentWithCategoryDTO> allCategoryWithDocument = documentService.getAllCategoryWithDocument();
        log.info("所有文档分类下的所有文档数据：{}", allCategoryWithDocument);
        return Result.success(allCategoryWithDocument);
    }

}

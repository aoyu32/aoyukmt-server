package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.DocumentWithCategoryDTO;

import java.util.List;

/**
 * @InterfaceName：DocumentService
 * @Author: aoyu
 * @Date: 2025/3/8 下午4:20
 * @Description:
 */

public interface DocumentService {

    /**
     * 获取所有分类下的所有文档
     * @return
     */
    List<DocumentWithCategoryDTO> getAllCategoryWithDocument();


}

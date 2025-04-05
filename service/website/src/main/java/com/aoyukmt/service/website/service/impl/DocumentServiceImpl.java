package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.dto.DocumentWithCategoryDTO;
import com.aoyukmt.service.website.mapper.DocumentMapper;
import com.aoyukmt.service.website.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName：DocumentServiceImpl
 * @Author: aoyu
 * @Date: 2025-03-08 16:20
 * @Description: 使用文档接口实现类
 */

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    private static final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Override
    public List<DocumentWithCategoryDTO> getAllCategoryWithDocument() {
        log.info("获取所有文档分类和该分类下的所有文档...");
        return documentMapper.selectAllCategoryWithDocument();
    }
}

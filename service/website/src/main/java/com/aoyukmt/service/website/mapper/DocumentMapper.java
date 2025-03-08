package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.DocumentWithCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @InterfaceName：DocumentMapper
 * @Author: aoyu
 * @Date: 2025/3/8 下午4:44
 * @Description:
 */

@Mapper
public interface DocumentMapper {

    /**
     * 查询所有分类下的所有文档
     * @return
     */
    List<DocumentWithCategoryDTO> selectAllCategoryWithDocument();

}

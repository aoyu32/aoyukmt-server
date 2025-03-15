package com.aoyukmt.model.vo;

import lombok.Data;

/**
 * @ClassName：HistoryAppVO
 * @Author: aoyu
 * @Date: 2025-03-15 22:57
 * @Description: 历史版本请求参数实体
 */

@Data
public class HistoryAppVO {

    /**
     * 下载用户id
     */
    private String uid;

    /**
     * 版本号
     */
    private String version;

    /**
     * 安装包类型
     */
    private String packageType;

}

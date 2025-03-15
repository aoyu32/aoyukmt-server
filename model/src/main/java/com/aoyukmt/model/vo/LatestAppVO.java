package com.aoyukmt.model.vo;

/**
 * @ClassName：LatestAppVO
 * @Author: aoyu
 * @Date: 2025-03-15 22:51
 * @Description: 最新版本请求数据
 */

import lombok.Data;

@Data
public class LatestAppVO {

    /**
     * 下载用户id
     */
    private String uid;

    /**
     * 安装包类型
     */
    private String packageType;

}

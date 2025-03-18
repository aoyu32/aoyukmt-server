package com.aoyukmt.model.vo;

import com.aoyukmt.annotation.PackageTypeValidation;
import com.aoyukmt.annotation.VersionValidation;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String uid;

    /**
     * 版本号
     */

    @VersionValidation
    private String version;

    /**
     * 安装包类型
     */
    @PackageTypeValidation
    private String packageType;

}

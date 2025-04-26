package com.aoyukmt.model.vo.req;

/**
 * @ClassName：LatestAppVO
 * @Author: aoyu
 * @Date: 2025-03-15 22:51
 * @Description: 最新版本请求数据
 */

import com.aoyukmt.common.annotation.PackageTypeValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LatestAppVO {

    /**
     * 下载用户id
     */
    @NotBlank
    private String uid;

    /**
     * 安装包类型
     */
    @PackageTypeValidation
    private String packageType;

}

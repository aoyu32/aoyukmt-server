package com.aoyukmt.common.constant;

/**
 * @ClassName：ValidationConstant
 * @Author: aoyu
 * @Date: 2025-03-18 10:59
 * @Description: 数据校验常量
 */

public class ValidationConstant {

    //版本号格式不正确
    public static final String VERSION_FORMAT_ERROR = "版本号格式不正确，正确格式： x.y.z";

    //未知安装包类型
    public static final String UNKNOWN_PACKAGE_TYPE = "未知安装包类型，正确类型：['installer','zip']";

    //未知版本类型
    public static final String UNKNOWN_VERSION_TYPE = "未知版本类型，正确类型：['latest','history]";

    //应用名称格式错误
    public static final String APP_NAME_FORMAT_ERROR = "应用名称格式错误，正确类型：aoyukmt-x.y.z.(exe || zip)";

}

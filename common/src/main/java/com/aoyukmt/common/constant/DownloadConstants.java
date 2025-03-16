package com.aoyukmt.common.constant;

/**
 * @ClassName：DownloadConstants
 * @Author: aoyu
 * @Date: 2025-03-12 22:11
 * @Description: 下载频率限制常量
 */

public class DownloadConstants {

    //最大请求数
    public static final int MAX_REQUESTS = 5;

    //最大请求时间单位
    public static final int TIME_WINDOW = 30;

    //下载id的redis缓存过期时间
    public static final int DOWNLOAD_ID_TIMEOUT = 30;

    //安装包
    public static final String INSTALLER = "installer";

    //压缩包
    public static final String ZIP = "zip";

    //exe后缀
    public static final String EXE_FILE = ".exe";

    //zip后缀
    public static final String ZIP_FILE = ".zip";

}

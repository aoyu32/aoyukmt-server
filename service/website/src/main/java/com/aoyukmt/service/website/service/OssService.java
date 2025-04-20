package com.aoyukmt.service.website.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @InterfaceName：OssService
 * @Author: aoyu
 * @Date: 2025/4/20 下午3:28
 * @Description: oss业务层接口
 */


public interface OssService {

    /**
     * 上传一个文件
     * @return
     */
    String upload(MultipartFile file,String ossDir) throws IOException;

    /**
     * 批量上传文件
     * @param fileList 文件列表
     * @return
     */
    List<String> uploadFileList(List<MultipartFile> fileList,String ossDir)  throws IOException;


}

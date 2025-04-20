package com.aoyukmt.model.vo.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName：FeedbackSubmitReqVO
 * @Author: aoyu
 * @Date: 2025-04-20 14:12
 * @Description: 用户请求投递反馈参数的VO
 */

@Data
public class FeedbackSubmitReqVO {

    /**
     * 反馈人名称
     */
    private String responder;

    /**
     * 反馈类型
     */
    private String type;

    /**
     * 用户反馈内容
     */
    private String content;

    /**
     * 用户反馈附件列表
     */
    private List<MultipartFile> files;

}

package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：FeedbackSubmitAttachmentDTO
 * @Author: aoyu
 * @Date: 2025-04-20 16:20
 * @Description: 用户提交的附件的数据的DTO
 */

@Data
public class FeedbackSubmitAttachmentDTO {

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 用户反馈信息表id
     */
    private Integer feedbackId;

    /**
     * 附件文件名
     */
    private String fileName;

    /**
     * 文件url
     */
    private String fileUrl;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private Integer fileSize;


}

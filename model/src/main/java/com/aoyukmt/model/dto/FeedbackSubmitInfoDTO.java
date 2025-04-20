package com.aoyukmt.model.dto;

import lombok.Data;

/**
 * @ClassName：FeedbackSubmitDTO
 * @Author: aoyu
 * @Date: 2025-04-20 14:05
 * @Description: 用户投递反馈dto
 */

@Data
public class FeedbackSubmitInfoDTO {

    /**
     * 反馈消息id
     */
    private Integer id;

    /**
     * 用户uid
     */
    private Long uid;

    /**
     * 反馈类型
     */
    private String type;

    /**
     * 反馈人名称
     */
    private String responder;

    /**
     * 用户反馈内容
     */
    private String content;


}

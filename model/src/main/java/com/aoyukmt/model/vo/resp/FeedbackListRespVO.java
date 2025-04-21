package com.aoyukmt.model.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName：FeedbackList
 * @Author: aoyu
 * @Date: 2025-04-21 08:12
 * @Description: 用户反馈列表
 */

@Data
public class FeedbackListRespVO {

    /**
     * 反馈id
     */
    private Integer id;

    /**
     * 反馈人姓名
     */
    private String responder;

    /**
     * 反馈内容
     */
    private String content;

    /**
     * 反馈类型
     */
    private String type;

    /**
     * 反馈附件列表
     */
    private List<String> attachments;

    /**
     * 反馈时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}

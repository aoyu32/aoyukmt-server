package com.aoyukmt.model.vo.req;

import lombok.Data;

/**
 * @ClassName：UserChatReqVO
 * @Author: aoyu
 * @Date: 2025-04-26 09:46
 * @Description: 用户聊天请求VO
 */

@Data
public class UserChatReqVO {

    /**
     * 会话id
     */
    private String id;

    /**
     * 会话内容
     */
    private String message;



}

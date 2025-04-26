package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.req.UserChatReqVO;
import com.aoyukmt.model.vo.resp.ChatMessageRespVO;
import reactor.core.publisher.Flux;

/**
 * @InterfaceName：AssistantService
 * @Author: aoyu
 * @Date: 2025/4/26 上午9:38
 * @Description:
 */

public interface AssistantService {

    /**
     * 用户聊天
     * @return 流式聊天数据
     */
    Flux<ChatMessageRespVO> chat(UserChatReqVO userChatReqVO);

}

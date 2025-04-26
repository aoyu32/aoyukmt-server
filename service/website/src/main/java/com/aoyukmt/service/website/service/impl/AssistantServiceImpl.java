package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.vo.req.UserChatReqVO;
import com.aoyukmt.model.vo.resp.ChatMessageRespVO;
import com.aoyukmt.service.website.service.AssistantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @ClassName：AssistantServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-26 09:39
 * @Description: 智能助手业务接口实现类
 */

@Service
@Slf4j
public class AssistantServiceImpl implements AssistantService {

    @Autowired
    private ChatClient chatClient;

    @Override
    public Flux<ChatMessageRespVO> chat(UserChatReqVO userChatReqVO) {
        log.info("用户请求聊天的会话ID:{},聊天数据：{}",userChatReqVO.getId(),userChatReqVO.getMessage());
        return chatClient.prompt()
                .user(userChatReqVO.getMessage())
                .stream()
                .content()
                .map(chunk -> {
                    // 清理数据（如移除 SSE 的 "data:" 前缀）
                    String cleanChunk = chunk.startsWith("data:") ?
                            chunk.substring(5).trim() : chunk;
                    return new ChatMessageRespVO(cleanChunk, false);
                })
                .doOnNext(System.out::println);
    }
}

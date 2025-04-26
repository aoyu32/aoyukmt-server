package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.vo.req.UserChatReqVO;
import com.aoyukmt.model.vo.resp.ChatMessageRespVO;
import com.aoyukmt.service.website.service.AssistantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @ClassName：AssistantController
 * @Author: aoyu
 * @Date: 2025-04-24 10:29
 * @Description: 智能助手控制器类

 */
@RestController
@RequestMapping("/web/assistant")
@Slf4j
@Tag(name = "智能助手", description = "智能助手相关接口")
public class AssistantController {

    @Autowired
    private AssistantService assistantService;

    @Operation(summary = "对话聊天",description = "用户与智能助手聊天对话接口")
    @PostMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatMessageRespVO> Chat(@RequestBody UserChatReqVO userChatReqVO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}，请求聊天的会话ID:{},聊天数据：{}", uid,userChatReqVO.getId(), userChatReqVO.getMessage());
        return assistantService.chat(userChatReqVO);
    }


}

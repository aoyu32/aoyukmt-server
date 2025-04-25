package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.util.Map;

/**
 * @ClassName：AssistantController
 * @Author: aoyu
 * @Date: 2025-04-24 10:29
 * @Description: 智能助手控制器类
 */

@RestController
@RequestMapping("/web/assistant")
@Slf4j
@Tag(name="智能助手",description = "智能助手相关接口")
public class AssistantController {

    @Autowired
    private ChatClient chatClient;

    @PostMapping(value = "/chat",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ChatResponse> Chat(@RequestBody Map<String,String> params){
        log.info("聊天参数:{}",params.get("content"));
        Flux<ChatResponse> stringFlux = chatClient.prompt("你是aoyukmt的官方客服")
                .user(params.get("content"))
                .stream()
                .chatResponse()
                .doOnNext(System.out::println);
        return stringFlux;

    }

}

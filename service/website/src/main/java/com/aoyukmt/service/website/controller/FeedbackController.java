package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.vo.req.FeedbackSubmitReqVO;
import com.aoyukmt.model.vo.resp.FeedbackListRespVO;
import com.aoyukmt.service.website.service.FeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName：FeedbckController
 * @Author: aoyu
 * @Date: 2025-04-20 13:58
 * @Description: 用户反馈控制器
 */

@RestController
@RequestMapping("/web/feedback")
@Tag(name = "用户反馈", description = "用户反馈相关接口")
@Slf4j
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Operation(summary = "投递反馈", description = "用户发送反馈接口")
    @PostMapping("/submit")
    public Result<?> submit(@ModelAttribute FeedbackSubmitReqVO feedbackSubmitReqVO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}提交了一条反馈信息，反馈信息：{}", uid, feedbackSubmitReqVO);
        feedbackService.submit(uid, feedbackSubmitReqVO);
        log.info("反馈成功");
        return Result.success();
    }

    @GetMapping("/query")
    public Result<List<FeedbackListRespVO>> queryFeedback() {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}请求查询他的反馈", uid);
        List<FeedbackListRespVO> feedbackList = feedbackService.getFeedbackList(uid);
        log.info("查询完成uid为{}的所有反馈：{}",uid,feedbackList);
        return Result.success(feedbackList);
    }

}

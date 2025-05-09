package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.req.FeedbackSubmitReqVO;
import com.aoyukmt.model.vo.resp.FeedbackListRespVO;

import java.util.List;

/**
 * @InterfaceName：FeedbackService
 * @Author: aoyu
 * @Date: 2025/4/20 下午2:30
 * @Description:
 */

public interface FeedbackService {

    /**
     * 提交反馈
     * @param uid 用户uid
     * @param feedbackSubmitReqVO 用户反馈内容参数实体
     */
    void submit(Long uid, FeedbackSubmitReqVO feedbackSubmitReqVO);


    /**
     * 获取某用户的所有反馈
     * @param uid 用户id
     * @return 反馈列表
     */
    List<FeedbackListRespVO> getFeedbackList(Long uid);

}

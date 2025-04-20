package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.constant.FeedbackConstant;
import com.aoyukmt.common.enumeration.FeedbackTypeEnum;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.model.dto.FeedbackSubmitAttachmentDTO;
import com.aoyukmt.model.dto.FeedbackSubmitInfoDTO;
import com.aoyukmt.model.vo.req.FeedbackSubmitReqVO;
import com.aoyukmt.service.website.mapper.FeedbackMapper;
import com.aoyukmt.service.website.service.FeedbackService;
import com.aoyukmt.service.website.service.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName：FeedbackServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-20 14:31
 * @Description: 用户反馈业务层接口实现类
 */

@Service
@Slf4j
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private OssService ossService;

    /**
     * 提交反馈
     *
     * @param uid                 用户uid
     * @param feedbackSubmitReqVO 用户反馈内容参数实体
     */
    @Override
    @Transactional
    public void submit(Long uid, FeedbackSubmitReqVO feedbackSubmitReqVO) {

        log.info("开始处理用户uid为：{}的反馈", uid);

        //反馈文本内容
        String content = feedbackSubmitReqVO.getContent();
        log.info("反馈的文本内容：{}",content);
        //附件列表
        List<MultipartFile> multipartFiles = feedbackSubmitReqVO.getFiles();
        log.info("反馈的附件：{}",multipartFiles);

        //判断反馈类型是否符合要求
        if (!FeedbackTypeEnum.isValidType(feedbackSubmitReqVO.getType())) {
            throw new BusinessException(ResultCode.UNKNOWN_FEEDBACK_TYPE);
        }

        //判断是否有反馈内容
        if(content.isEmpty() && (multipartFiles == null || multipartFiles.isEmpty())) {
            throw new BusinessException(ResultCode.ERROR);
        }

        //判断是否有文本反馈内容
        log.info("用户填写了反馈内容");
        FeedbackSubmitInfoDTO feedbackSubmitInfoDTO = new FeedbackSubmitInfoDTO();
        feedbackSubmitInfoDTO.setType(feedbackSubmitReqVO.getType());
        feedbackSubmitInfoDTO.setContent(feedbackSubmitReqVO.getContent());
        feedbackSubmitInfoDTO.setUid(uid);
        feedbackSubmitInfoDTO.setResponder(feedbackSubmitReqVO.getResponder());

        //插入反馈信息
        Integer res = feedbackMapper.insert(feedbackSubmitInfoDTO);
        if (res < 0) {
            throw new BusinessException(ResultCode.ERROR);
        }
        //判断是否上传了附件
        if (!(multipartFiles == null || multipartFiles.isEmpty())) {
            log.info("用户上传了附件");

            try {
                List<String> fileUrls = ossService.uploadFileList(feedbackSubmitReqVO.getFiles(), FeedbackConstant.FEEDBACK_ATTACHMENTS_DIR_PATH);
                List<FeedbackSubmitAttachmentDTO> feedbackSubmitAttachmentDTOS = new ArrayList<>();

                for (int i = 0; i < multipartFiles.size(); i++) {
                    FeedbackSubmitAttachmentDTO feedbackSubmitAttachmentDTO = new FeedbackSubmitAttachmentDTO();
                    feedbackSubmitAttachmentDTO.setFeedbackId(feedbackSubmitInfoDTO.getId());
                    feedbackSubmitAttachmentDTO.setUid(uid);
                    feedbackSubmitAttachmentDTO.setFileUrl(fileUrls.get(i));
                    feedbackSubmitAttachmentDTO.setFileSize((int) multipartFiles.get(i).getSize());
                    feedbackSubmitAttachmentDTO.setFileName(multipartFiles.get(i).getOriginalFilename());
                    feedbackSubmitAttachmentDTO.setFileType(multipartFiles.get(i).getContentType());
                    feedbackSubmitAttachmentDTOS.add(feedbackSubmitAttachmentDTO);
                }
                //插入附件到数据库
                Integer result = feedbackMapper.insertAttachment(feedbackSubmitAttachmentDTOS);
                if(result < 0) {
                    throw new BusinessException(ResultCode.ERROR);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

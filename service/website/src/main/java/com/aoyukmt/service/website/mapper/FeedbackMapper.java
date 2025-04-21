package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.FeedbackSubmitAttachmentDTO;
import com.aoyukmt.model.dto.FeedbackSubmitInfoDTO;
import com.aoyukmt.model.vo.resp.FeedbackListRespVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * @InterfaceName：FeedbackMapper
 * @Author: aoyu
 * @Date: 2025/4/20 下午2:32
 * @Description:
 */

@Mapper
public interface FeedbackMapper {

    /**
     * 插入用户反馈的信息，不包含用户上传的附件
     * @param feedbackSubmitInfoDTO 用户反馈基本信息
     * @return 插入结果
     */
    @Insert("insert into feedback (uid,responder,content,type) values(#{uid},#{responder},#{content},#{type})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Integer insert(FeedbackSubmitInfoDTO feedbackSubmitInfoDTO);

    /**
     * 批量插入用户反馈的附件信息
     * @param files 反馈附件信息
     * @return 结果
     */
    Integer insertAttachment(List<FeedbackSubmitAttachmentDTO> files);


    /**
     * 根据uid查询该用户的所有反馈
     * @param uid 用户uid
     * @return 用户反馈列表
     */
    List<FeedbackListRespVO> selectAll(Long uid);
}

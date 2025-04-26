package com.aoyukmt.model.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName：ChatMessageRespVO
 * @Author: aoyu
 * @Date: 2025-04-26 15:22
 * @Description:
 */

@Data
@AllArgsConstructor
public class ChatMessageRespVO {
   private String message;
   private Boolean isEnd;
}

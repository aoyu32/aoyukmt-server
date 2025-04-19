package com.aoyukmt.service.website;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @ClassName：UserIp
 * @Author: aoyu
 * @Date: 2025-04-19 11:56
 * @Description:
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIp {
    private String ip;
    private String pro;
    private String proCode;
    private String city;
    private String cityCode;
    private String region;
    private String regionCode;
    private String addr;
    private String addrCode;
    private String regionNames;
}

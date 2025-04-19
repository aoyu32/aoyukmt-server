package com.aoyukmt.service.website;

import com.aoyukmt.common.utils.IpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName：testIp
 * @Author: aoyu
 * @Date: 2025-04-19 11:41
 * @Description: 测试获取ip归属地
 */

@SpringBootTest
public class testIp {

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void ip() throws JsonProcessingException, UnknownHostException {
//        InetAddress localHost = InetAddress.getLocalHost();
        String IP = "10.205.71.69";
        String url = "https://whois.pconline.com.cn/ipJson.jsp?" + "ip=" + IP + "&json=true";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);
        ObjectMapper mapper = new ObjectMapper();
        UserIp userIp = mapper.readValue(forObject, UserIp.class);
        System.out.println(userIp.getIp());
        System.out.println(userIp.getCity());

    }

}

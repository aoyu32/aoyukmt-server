package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.avatar.DiceBearAvatarGenerator;
import com.aoyukmt.common.constant.RedisKeyPrefixConstant;
import com.aoyukmt.common.constant.UserConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.AliYunOSSUtils;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserUpdateDTO;
import com.aoyukmt.service.website.mapper.UserProfileMapper;
import com.aoyukmt.service.website.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName：UserProfileServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-08 10:55
 * @Description: 用户信息接口实现类
 */

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private AliYunOSSUtils aliyunOSSUtils;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * 查询用户信息
     *
     * @param uid
     * @return
     */
    @Override
    public UserInfoDTO getUserInfo(Long uid) {
        log.info("开始查询 uid 为{}的用户信息", uid);
        return userProfileMapper.selectUserInfoByUid(uid);
    }


    /**
     * 更新用户信息
     *
     * @param userUpdateDTO 用户需要更新的参数
     * @return
     */
    @Override
    public Integer userUpdate(UserUpdateDTO userUpdateDTO) {

        log.info("开始更新用户信息，UID: {}，更新内容: {}", userUpdateDTO.getUid(), userUpdateDTO);
        Integer result = userProfileMapper.updateUserById(userUpdateDTO);
        if (result > 0) {
            log.info("更新成功");
        } else {
            throw new BusinessException(440, "更新失败");
        }
        return result;
    }

    @Override
    public String avatar(String action, MultipartFile file) throws IOException {
        //获取用户id
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("开始更新uid为：{}的用户头像",uid);


        String avatarUrl="";

        //判断是随机生成头像请求还是上次了头像
        if (file.isEmpty()) {

            //判断是提交随机头像还是生成随机头像还是取消随机头像
            if (action.equals("generate")) {
                //生成随机头像链接返回
                log.info("用户需要生成随机头像");
                 avatarUrl = DiceBearAvatarGenerator.generateRandomAvatarUrl();
                log.info("为uid为：{}生成的随机头像url：{}", uid, avatarUrl);
                //将随机头像存入redis中
                redisTemplate.opsForValue().set(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid, avatarUrl);
                //返回随机头像
                return avatarUrl;
            }
            //提交随机头像
            if(action.equals("confirm")){
                log.info("用户需要提交生成的随机头像");
                String randomAvatarUrl = redisTemplate.opsForValue().get(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                if(randomAvatarUrl != null){
                    //更新数据库中的头像url
                    userProfileMapper.updateAvatarById(uid, randomAvatarUrl);
                    avatarUrl = redisTemplate.opsForValue().get(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                    redisTemplate.delete(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                    return avatarUrl;
                }else {
                    throw new BusinessException(ResultCode.ERROR);
                }
            }
            //取消提交随机头像
            if(action.equals("cancel")){
                log.info("用户要取消提交生成的随机头像");
                redisTemplate.delete(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                return avatarUrl;
            }
        }else {
            //判断文件类型
            String contentType = file.getContentType();
            log.info("用户上次的文件类型：{}", contentType);
            if (!UserConstant.FILE_TYPE.contains(contentType)) {
                throw new BusinessException(ResultCode.UNSUPPORTED_FILE_TYPE);
            }

            //判断文件大小
            if (file.getSize() > UserConstant.MAX_AVATAR_IMAGE_FILE_SIZE) {
                throw new BusinessException(ResultCode.UPLOAD_IMG_MAX);
            }

            //上传图片
            avatarUrl = aliyunOSSUtils.uploadFile(file.getBytes(), file.getOriginalFilename());
            log.info("上传头像图片到OSS，返回图片url: {}", avatarUrl);


            //更新数据库中的头像url
            Integer result = userProfileMapper.updateAvatarById(uid, avatarUrl);

            if (result <= 0) {
                log.info("更新用户头像失败：{}", result);
                throw new BusinessException(ResultCode.ERROR);
            }

            log.info("更新用户头像成功：{}", result);
            //返回图片连接
        }

        return avatarUrl;


    }
}

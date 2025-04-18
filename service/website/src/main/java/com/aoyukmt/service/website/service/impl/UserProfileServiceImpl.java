package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.avatar.DiceBearAvatarGenerator;
import com.aoyukmt.common.constant.RedisKeyPrefixConstant;
import com.aoyukmt.common.constant.UserConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.AliYunOSSUtils;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

    /**
     * 本地头像上传服务
     *
     * @param file
     * @return 本地头像上传后的url
     * @throws IOException
     */
    @Override
    public String localAvatar(Long uid, MultipartFile file) throws IOException {
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
        String avatarUrl = aliyunOSSUtils.uploadFile(file.getBytes(), file.getOriginalFilename());
        log.info("上传头像图片到OSS，返回图片url: {}", avatarUrl);


        //更新数据库中的头像url
        Integer result = userProfileMapper.updateAvatarById(uid, avatarUrl);

        if (result <= 0) {
            log.info("更新用户头像失败：{}", result);
            throw new BusinessException(ResultCode.ERROR);
        }

        log.info("更新用户头像成功：{}", result);


        //返回图片连接
        return avatarUrl;
    }

    /**
     * 随机头像服务
     *
     * @return 随机头像url
     */
    @Override
    public String randomAvatar(Long uid,String action) {
        if(!Set.of(UserConstant.USER_CONFIRM_RANDOM_AVATAR_ACTION,UserConstant.USER_GENERATE_RANDOM_AVATAR_ACTION).contains(action))
            throw new BusinessException(ResultCode.ERROR);

        String avatarUrl = "";
        //执行生成随机头像返回
        if(action.equals(UserConstant.USER_GENERATE_RANDOM_AVATAR_ACTION)){
            //生成随机头像链接返回
            log.info("用户需要生成随机头像");
            avatarUrl = DiceBearAvatarGenerator.generateRandomAvatarUrl();
            log.info("为uid为：{}生成的随机头像url：{}", uid, avatarUrl);
            //将随机头像存入redis中
            redisTemplate.opsForValue().set(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid, avatarUrl, 10, TimeUnit.MINUTES);
        }
        //提交生成的随机头像
        if(action.equals(UserConstant.USER_CONFIRM_RANDOM_AVATAR_ACTION)){
            log.info("用户需要提交生成的随机头像");
                String randomAvatarUrl = redisTemplate.opsForValue().get(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                if (randomAvatarUrl != null) {
                    //更新数据库中的头像url
                    userProfileMapper.updateAvatarById(uid, randomAvatarUrl);
                    avatarUrl = redisTemplate.opsForValue().get(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                    redisTemplate.delete(RedisKeyPrefixConstant.USER_RANDOM_AVATAR + uid);
                } else {
                    log.info("头像已经过期");
                    throw new BusinessException(ResultCode.RANDOM_AVATAR_EXPIRED);
                }
        }
        //返回随机头像
        return avatarUrl;
    }

}

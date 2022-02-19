package org.juhepay.merchant.service;

import org.juhepay.common.domain.BusinessException;

/**
 * @ClassName SmsService
 * @Description 验证码接口
 * @Author lily
 * @Date 2021/1/22 2:34 下午
 * @Version 1.0
 */
public interface SmsService {
    /**
     * 获取短信验证码
     * @param phone
     * @return
     */
    String sendMsg(String phone);

    /**
     * 校验验证码，抛出异常则校验无效
     * @param verifiyKey 验证码key
     * @param verifiyCode 验证码
     */
    void checkVerifiyCode(String verifiyKey,String verifiyCode) throws BusinessException;
}

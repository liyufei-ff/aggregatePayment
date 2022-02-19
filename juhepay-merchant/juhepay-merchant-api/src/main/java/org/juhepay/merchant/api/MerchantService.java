package org.juhepay.merchant.api;

import org.juhepay.common.domain.BusinessException;
import org.juhepay.merchant.api.dto.MerchantDTO;

/**
 * @ClassName MerchantService
 * @Description
 * @Author lily
 * @Date 2021/1/21 2:43 下午
 * @Version 1.0
 */
public interface MerchantService {

    /**
     * 根据ID查询详细信息
     * @param merchantId
     * @return
     */
    MerchantDTO queryMerchantById(Long merchantId);

    /**
     * 注册商户服务接口，接收账号、密码、手机号，为了可扩展性使用merchantDto接收数据
     * @param merchantDTO 商户注册信息
     * @return 注册成功的商户信息
     */
    MerchantDTO createMerchant(MerchantDTO merchantDTO) throws BusinessException;


    /**
     * 资质申请接口
     * @param merchantId 商户id
     * @param merchantDTO 资质申请的信息
     * @throws BusinessException
     */
    void applyMerchant(Long merchantId,MerchantDTO merchantDTO) throws BusinessException;


}

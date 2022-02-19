package org.juhepay.merchant.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.juhepay.common.domain.BusinessException;
import org.juhepay.common.domain.CommonErrorCode;
import org.juhepay.common.domain.ErrorCode;
import org.juhepay.common.util.PhoneUtil;
import org.juhepay.merchant.api.MerchantService;
import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.convert.MerchantConvert;
import org.juhepay.merchant.entity.Merchant;
import org.juhepay.merchant.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName MerchantServiceImpl
 * @Description
 * @Author lily
 * @Date 2021/1/21 2:55 下午
 * @Version 1.0
 */
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;


    @Override
    public MerchantDTO queryMerchantById(Long merchantId) {
        Merchant merchant = merchantMapper.selectById(merchantId);
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setId(merchant.getId());
        merchantDTO.setMerchantName(merchant.getMerchantName());
        return merchantDTO;
    }

    @Override
    public MerchantDTO createMerchant(MerchantDTO merchantDTO) throws BusinessException {
        // 1.校验
        if (merchantDTO == null) {
            throw new BusinessException(CommonErrorCode.E_100108);
        }
        //手机号非空校验
        if (StringUtils.isBlank(merchantDTO.getMobile())) {
            throw new BusinessException(CommonErrorCode.E_100112);
        }
        //校验手机号的合法性
        if (!PhoneUtil.isMatches(merchantDTO.getMobile())) {
            throw new BusinessException(CommonErrorCode.E_100109);
        }
        //联系人非空校验
        if (StringUtils.isBlank(merchantDTO.getUsername())) {
            throw new BusinessException(CommonErrorCode.E_100110);
        }
        //密码非空校验
        if (StringUtils.isBlank(merchantDTO.getPassword())) {
            throw new BusinessException(CommonErrorCode.E_100111);
        }
        //校验商户手机号的唯一性,根据商户的手机号查询商户表，如果存在记录则说明已有相同的手机号重复
        LambdaQueryWrapper<Merchant> lambdaQryWrapper = new LambdaQueryWrapper<Merchant>()
                .eq(Merchant::getMobile,merchantDTO.getMobile());
        Integer count = merchantMapper.selectCount(lambdaQryWrapper);
        if(count>0){
            throw new BusinessException(CommonErrorCode.E_100113);
        }
        Merchant merchant = MerchantConvert.INSTANCE.dto2entity(merchantDTO);
        //设置审核状态 0-为申请
        merchant.setAuditStatus("0");
        //添加商户信息
        merchantMapper.insert(merchant);
        merchantDTO = MerchantConvert.INSTANCE.entity2dto(merchant);
        return merchantDTO;
    }

    @Override
    public void applyMerchant(Long merchantId, MerchantDTO merchantDTO) throws BusinessException {
        if(merchantId==null || merchantDTO ==null){
            throw new BusinessException(CommonErrorCode.E_100108);
        }
        //根据id查询指定对象
        Merchant merchant = merchantMapper.selectById(merchantId);
        if(merchant==null){
            throw new BusinessException(CommonErrorCode.E_200002);
        }
        Merchant merchant_update = MerchantConvert.INSTANCE.dto2entity(merchantDTO);
        merchant_update.setId(merchant.getId());
        merchant_update.setAuditStatus("1");
        //更新
        merchantMapper.updateById(merchant_update);
    }
}













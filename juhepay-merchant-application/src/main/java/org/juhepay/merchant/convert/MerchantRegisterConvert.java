package org.juhepay.merchant.convert;

import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.vo.MerchantRegisterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName MerchantRegisterConvert
 * @Description 将商户注册vo和dto进行转换
 * @Author lily
 * @Date 2021/1/22 4:56 下午
 * @Version 1.0
 */
@Mapper
public interface MerchantRegisterConvert {

    MerchantRegisterConvert INSTANCE = Mappers.getMapper(MerchantRegisterConvert.class);

    //将dto转成vo
    MerchantRegisterVO dto2vo(MerchantDTO merchantDTO);
    //将vo转成dto
    MerchantDTO vo2dto(MerchantRegisterVO merchantRegisterVO);

}

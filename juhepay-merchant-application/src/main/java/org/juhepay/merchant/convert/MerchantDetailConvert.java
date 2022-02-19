package org.juhepay.merchant.convert;

import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.vo.MerchantDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName MerchantDetailConvert
 * @Description
 * @Author lily
 * @Date 2021/1/24 2:48 下午
 * @Version 1.0
 */
@Mapper
public interface MerchantDetailConvert {
    MerchantDetailConvert INSTANCE = Mappers.getMapper(MerchantDetailConvert.class);
    MerchantDTO vo2dto(MerchantDetailVO vo);
    MerchantDetailVO dto2vo(MerchantDTO dto);
}

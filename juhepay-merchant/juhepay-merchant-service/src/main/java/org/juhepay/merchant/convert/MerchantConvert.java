package org.juhepay.merchant.convert;

import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MerchantConvert
 * @Description
 * @Author lily
 * @Date 2021/1/22 4:49 下午
 * @Version 1.0
 */
@Mapper //对象属性的映射
public interface MerchantConvert {

    //转换类实例
    MerchantConvert INSTANCE = Mappers.getMapper(MerchantConvert.class);

    //把dto转换成entity
    Merchant dto2entity(MerchantDTO merchantDTO);

    //把entity转换成dto
    MerchantDTO entity2dto(Merchant merchant);

    //list之间也可以转换，很entity的List转成MerchantDTO list
    List<MerchantDTO> entityList2dtoList(List<Merchant> merchants);

}

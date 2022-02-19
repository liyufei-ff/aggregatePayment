package org.juhepay.merchant.convert;

import javax.annotation.Generated;
import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.vo.MerchantRegisterVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-25T16:56:19+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MerchantRegisterConvertImpl implements MerchantRegisterConvert {

    @Override
    public MerchantRegisterVO dto2vo(MerchantDTO merchantDTO) {
        if ( merchantDTO == null ) {
            return null;
        }

        MerchantRegisterVO merchantRegisterVO = new MerchantRegisterVO();

        merchantRegisterVO.setMobile( merchantDTO.getMobile() );
        merchantRegisterVO.setUsername( merchantDTO.getUsername() );
        merchantRegisterVO.setPassword( merchantDTO.getPassword() );

        return merchantRegisterVO;
    }

    @Override
    public MerchantDTO vo2dto(MerchantRegisterVO merchantRegisterVO) {
        if ( merchantRegisterVO == null ) {
            return null;
        }

        MerchantDTO merchantDTO = new MerchantDTO();

        merchantDTO.setUsername( merchantRegisterVO.getUsername() );
        merchantDTO.setPassword( merchantRegisterVO.getPassword() );
        merchantDTO.setMobile( merchantRegisterVO.getMobile() );

        return merchantDTO;
    }
}

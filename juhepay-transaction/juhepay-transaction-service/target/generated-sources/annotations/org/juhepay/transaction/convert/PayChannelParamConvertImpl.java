package org.juhepay.transaction.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.juhepay.transaction.api.dto.PayChannelParamDTO;
import org.juhepay.transaction.entity.PayChannelParam;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-26T09:45:34+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class PayChannelParamConvertImpl implements PayChannelParamConvert {

    @Override
    public PayChannelParamDTO entity2dto(PayChannelParam entity) {
        if ( entity == null ) {
            return null;
        }

        PayChannelParamDTO payChannelParamDTO = new PayChannelParamDTO();

        payChannelParamDTO.setId( entity.getId() );
        payChannelParamDTO.setChannelName( entity.getChannelName() );
        payChannelParamDTO.setMerchantId( entity.getMerchantId() );
        payChannelParamDTO.setPayChannel( entity.getPayChannel() );
        payChannelParamDTO.setParam( entity.getParam() );
        payChannelParamDTO.setAppPlatformChannelId( entity.getAppPlatformChannelId() );

        return payChannelParamDTO;
    }

    @Override
    public PayChannelParam dto2entity(PayChannelParamDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PayChannelParam payChannelParam = new PayChannelParam();

        payChannelParam.setId( dto.getId() );
        payChannelParam.setChannelName( dto.getChannelName() );
        payChannelParam.setMerchantId( dto.getMerchantId() );
        payChannelParam.setPayChannel( dto.getPayChannel() );
        payChannelParam.setParam( dto.getParam() );
        payChannelParam.setAppPlatformChannelId( dto.getAppPlatformChannelId() );

        return payChannelParam;
    }

    @Override
    public List<PayChannelParamDTO> listentity2listdto(List<PayChannelParam> PlatformChannel) {
        if ( PlatformChannel == null ) {
            return null;
        }

        List<PayChannelParamDTO> list = new ArrayList<PayChannelParamDTO>( PlatformChannel.size() );
        for ( PayChannelParam payChannelParam : PlatformChannel ) {
            list.add( entity2dto( payChannelParam ) );
        }

        return list;
    }

    @Override
    public List<PayChannelParam> listdto2listentity(List<PayChannelParamDTO> PlatformChannelDTO) {
        if ( PlatformChannelDTO == null ) {
            return null;
        }

        List<PayChannelParam> list = new ArrayList<PayChannelParam>( PlatformChannelDTO.size() );
        for ( PayChannelParamDTO payChannelParamDTO : PlatformChannelDTO ) {
            list.add( dto2entity( payChannelParamDTO ) );
        }

        return list;
    }
}

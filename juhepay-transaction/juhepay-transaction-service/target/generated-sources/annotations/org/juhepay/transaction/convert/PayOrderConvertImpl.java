package org.juhepay.transaction.convert;

import javax.annotation.Generated;
import org.juhepay.transaction.api.dto.OrderResultDTO;
import org.juhepay.transaction.api.dto.PayOrderDTO;
import org.juhepay.transaction.entity.PayOrder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-26T09:45:34+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class PayOrderConvertImpl implements PayOrderConvert {

    @Override
    public OrderResultDTO request2dto(PayOrderDTO payOrderDTO) {
        if ( payOrderDTO == null ) {
            return null;
        }

        OrderResultDTO orderResultDTO = new OrderResultDTO();

        orderResultDTO.setStoreId( payOrderDTO.getStoreId() );
        orderResultDTO.setAppId( payOrderDTO.getAppId() );
        orderResultDTO.setPayChannel( payOrderDTO.getPayChannel() );
        orderResultDTO.setChannel( payOrderDTO.getChannel() );
        orderResultDTO.setOutTradeNo( payOrderDTO.getOutTradeNo() );
        orderResultDTO.setSubject( payOrderDTO.getSubject() );
        orderResultDTO.setBody( payOrderDTO.getBody() );
        orderResultDTO.setCurrency( payOrderDTO.getCurrency() );
        orderResultDTO.setTotalAmount( payOrderDTO.getTotalAmount() );
        orderResultDTO.setOptional( payOrderDTO.getOptional() );
        orderResultDTO.setAnalysis( payOrderDTO.getAnalysis() );
        orderResultDTO.setExtra( payOrderDTO.getExtra() );
        orderResultDTO.setDevice( payOrderDTO.getDevice() );
        orderResultDTO.setClientIp( payOrderDTO.getClientIp() );
        orderResultDTO.setOpenId( payOrderDTO.getOpenId() );
        orderResultDTO.setAuthCode( payOrderDTO.getAuthCode() );

        return orderResultDTO;
    }

    @Override
    public PayOrderDTO dto2request(OrderResultDTO OrderResult) {
        if ( OrderResult == null ) {
            return null;
        }

        PayOrderDTO payOrderDTO = new PayOrderDTO();

        payOrderDTO.setStoreId( OrderResult.getStoreId() );
        payOrderDTO.setAppId( OrderResult.getAppId() );
        payOrderDTO.setChannel( OrderResult.getChannel() );
        payOrderDTO.setOutTradeNo( OrderResult.getOutTradeNo() );
        payOrderDTO.setSubject( OrderResult.getSubject() );
        payOrderDTO.setBody( OrderResult.getBody() );
        payOrderDTO.setCurrency( OrderResult.getCurrency() );
        payOrderDTO.setTotalAmount( OrderResult.getTotalAmount() );
        payOrderDTO.setOptional( OrderResult.getOptional() );
        payOrderDTO.setAnalysis( OrderResult.getAnalysis() );
        payOrderDTO.setExtra( OrderResult.getExtra() );
        payOrderDTO.setOpenId( OrderResult.getOpenId() );
        payOrderDTO.setAuthCode( OrderResult.getAuthCode() );
        payOrderDTO.setDevice( OrderResult.getDevice() );
        payOrderDTO.setPayChannel( OrderResult.getPayChannel() );
        payOrderDTO.setClientIp( OrderResult.getClientIp() );

        return payOrderDTO;
    }

    @Override
    public OrderResultDTO entity2dto(PayOrder entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResultDTO orderResultDTO = new OrderResultDTO();

        orderResultDTO.setId( entity.getId() );
        orderResultDTO.setTradeNo( entity.getTradeNo() );
        orderResultDTO.setMerchantId( entity.getMerchantId() );
        orderResultDTO.setStoreId( entity.getStoreId() );
        orderResultDTO.setAppId( entity.getAppId() );
        orderResultDTO.setPayChannel( entity.getPayChannel() );
        orderResultDTO.setPayChannelMchId( entity.getPayChannelMchId() );
        orderResultDTO.setPayChannelTradeNo( entity.getPayChannelTradeNo() );
        orderResultDTO.setChannel( entity.getChannel() );
        orderResultDTO.setOutTradeNo( entity.getOutTradeNo() );
        orderResultDTO.setSubject( entity.getSubject() );
        orderResultDTO.setBody( entity.getBody() );
        orderResultDTO.setCurrency( entity.getCurrency() );
        orderResultDTO.setTotalAmount( entity.getTotalAmount() );
        orderResultDTO.setOptional( entity.getOptional() );
        orderResultDTO.setAnalysis( entity.getAnalysis() );
        orderResultDTO.setExtra( entity.getExtra() );
        orderResultDTO.setTradeState( entity.getTradeState() );
        orderResultDTO.setErrorCode( entity.getErrorCode() );
        orderResultDTO.setErrorMsg( entity.getErrorMsg() );
        orderResultDTO.setDevice( entity.getDevice() );
        orderResultDTO.setClientIp( entity.getClientIp() );
        orderResultDTO.setCreateTime( entity.getCreateTime() );
        orderResultDTO.setUpdateTime( entity.getUpdateTime() );
        orderResultDTO.setExpireTime( entity.getExpireTime() );
        orderResultDTO.setPaySuccessTime( entity.getPaySuccessTime() );
        orderResultDTO.setPayChannelMchAppId( entity.getPayChannelMchAppId() );

        return orderResultDTO;
    }

    @Override
    public PayOrder dto2entity(OrderResultDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PayOrder payOrder = new PayOrder();

        payOrder.setId( dto.getId() );
        payOrder.setTradeNo( dto.getTradeNo() );
        payOrder.setMerchantId( dto.getMerchantId() );
        payOrder.setStoreId( dto.getStoreId() );
        payOrder.setAppId( dto.getAppId() );
        payOrder.setPayChannel( dto.getPayChannel() );
        payOrder.setPayChannelMchId( dto.getPayChannelMchId() );
        payOrder.setPayChannelMchAppId( dto.getPayChannelMchAppId() );
        payOrder.setPayChannelTradeNo( dto.getPayChannelTradeNo() );
        payOrder.setChannel( dto.getChannel() );
        payOrder.setOutTradeNo( dto.getOutTradeNo() );
        payOrder.setSubject( dto.getSubject() );
        payOrder.setBody( dto.getBody() );
        payOrder.setCurrency( dto.getCurrency() );
        payOrder.setTotalAmount( dto.getTotalAmount() );
        payOrder.setOptional( dto.getOptional() );
        payOrder.setAnalysis( dto.getAnalysis() );
        payOrder.setExtra( dto.getExtra() );
        payOrder.setTradeState( dto.getTradeState() );
        payOrder.setErrorCode( dto.getErrorCode() );
        payOrder.setErrorMsg( dto.getErrorMsg() );
        payOrder.setDevice( dto.getDevice() );
        payOrder.setClientIp( dto.getClientIp() );
        payOrder.setCreateTime( dto.getCreateTime() );
        payOrder.setUpdateTime( dto.getUpdateTime() );
        payOrder.setExpireTime( dto.getExpireTime() );
        payOrder.setPaySuccessTime( dto.getPaySuccessTime() );

        return payOrder;
    }
}

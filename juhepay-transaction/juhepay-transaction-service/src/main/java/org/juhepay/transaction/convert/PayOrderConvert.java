package org.juhepay.transaction.convert;

import org.juhepay.transaction.api.dto.OrderResultDTO;
import org.juhepay.transaction.api.dto.PayOrderDTO;
import org.juhepay.transaction.entity.PayOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayOrderConvert {

    PayOrderConvert INSTANCE = Mappers.getMapper(PayOrderConvert.class);

    OrderResultDTO request2dto(PayOrderDTO payOrderDTO);

    PayOrderDTO dto2request(OrderResultDTO OrderResult);

    OrderResultDTO entity2dto(PayOrder entity);

    PayOrder dto2entity(OrderResultDTO dto);

}

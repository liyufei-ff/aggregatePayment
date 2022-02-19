package org.juhepay.transaction.convert;

import org.juhepay.transaction.api.dto.OrderResultDTO;
import org.juhepay.transaction.entity.PayOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderResultConvert {

    OrderResultConvert INSTANCE = Mappers.getMapper(OrderResultConvert.class);

    OrderResultDTO entity2dto(PayOrder entity);

    PayOrder dto2entity(OrderResultDTO dto);
}

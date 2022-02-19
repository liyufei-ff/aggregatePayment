package org.juhepay.transaction.convert;

import org.juhepay.transaction.api.dto.PlatformChannelDTO;
import org.juhepay.transaction.entity.PlatformChannel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlatformChannelConvert {

    PlatformChannelConvert INSTANCE = Mappers.getMapper(PlatformChannelConvert.class);

    PlatformChannelDTO entity2dto(PlatformChannel entity);

    PlatformChannel dto2entity(PlatformChannelDTO dto);

    List<PlatformChannelDTO> listentity2listdto(List<PlatformChannel> PlatformChannel);
}

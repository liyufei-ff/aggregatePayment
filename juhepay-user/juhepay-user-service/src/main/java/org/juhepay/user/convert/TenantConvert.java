package org.juhepay.user.convert;

import org.juhepay.user.api.dto.tenant.TenantDTO;
import org.juhepay.user.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TenantConvert {

    TenantConvert INSTANCE = Mappers.getMapper(TenantConvert.class);

    TenantDTO entity2dto(Tenant entity);

    Tenant dto2entity(TenantDTO dto);
}

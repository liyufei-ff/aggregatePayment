package org.juhepay.user.convert;

import org.juhepay.user.api.dto.authorization.PrivilegeDTO;
import org.juhepay.user.entity.AuthorizationPrivilege;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorizationPrivilegeConvert {
    AuthorizationPrivilegeConvert INSTANCE = Mappers.getMapper(AuthorizationPrivilegeConvert.class);

    PrivilegeDTO entity2dto(AuthorizationPrivilege entity);

    AuthorizationPrivilege dto2entity(PrivilegeDTO dto);

    List<PrivilegeDTO> entitylist2dto(List<AuthorizationPrivilege>  authorizationRole);
}

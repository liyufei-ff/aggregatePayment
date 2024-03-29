package org.juhepay.user.convert;

import org.juhepay.user.api.dto.tenant.AccountDTO;
import org.juhepay.user.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountConvert {

    AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    //@Mappings({
    //        @Mapping(target="username", source="username")
    //})
    AccountDTO entity2dto(Account entity);


    //@Mappings({
    //        @Mapping(target="username", source="username"),
    //        @Mapping(target = "mobile",source="mobile"),
    //        @Mapping(target = "password",source="password"),
    //        @Mapping(target = "salt",source="salt")
    //})
    Account dto2entity(AccountDTO dto);

}

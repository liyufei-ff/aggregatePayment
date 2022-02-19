package org.juhepay.merchant.convert;

import org.juhepay.merchant.api.dto.AppDTO;
import org.juhepay.merchant.entity.App;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName AppCovert
 * @Description
 * @Author lily
 * @Date 2021/1/25 1:19 上午
 * @Version 1.0
 */
@Mapper
public interface AppCovert {
    AppCovert INSTANCE = Mappers.getMapper(AppCovert.class);
    AppDTO entity2dto(App entity);
    App dto2entity(AppDTO dto);
    List<AppDTO> listentity2dto(List<App> app);
}
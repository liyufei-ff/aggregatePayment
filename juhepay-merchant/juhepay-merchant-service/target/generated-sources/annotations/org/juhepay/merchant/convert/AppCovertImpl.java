package org.juhepay.merchant.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.juhepay.merchant.api.dto.AppDTO;
import org.juhepay.merchant.entity.App;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-25T15:58:19+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class AppCovertImpl implements AppCovert {

    @Override
    public AppDTO entity2dto(App entity) {
        if ( entity == null ) {
            return null;
        }

        AppDTO appDTO = new AppDTO();

        appDTO.setAppId( entity.getAppId() );
        appDTO.setAppName( entity.getAppName() );
        appDTO.setMerchantId( entity.getMerchantId() );
        appDTO.setPublicKey( entity.getPublicKey() );
        appDTO.setNotifyUrl( entity.getNotifyUrl() );

        return appDTO;
    }

    @Override
    public App dto2entity(AppDTO dto) {
        if ( dto == null ) {
            return null;
        }

        App app = new App();

        app.setAppId( dto.getAppId() );
        app.setAppName( dto.getAppName() );
        app.setMerchantId( dto.getMerchantId() );
        app.setPublicKey( dto.getPublicKey() );
        app.setNotifyUrl( dto.getNotifyUrl() );

        return app;
    }

    @Override
    public List<AppDTO> listentity2dto(List<App> app) {
        if ( app == null ) {
            return null;
        }

        List<AppDTO> list = new ArrayList<AppDTO>( app.size() );
        for ( App app1 : app ) {
            list.add( entity2dto( app1 ) );
        }

        return list;
    }
}

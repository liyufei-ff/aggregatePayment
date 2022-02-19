package org.juhepay.merchant.api;

import org.juhepay.common.domain.BusinessException;
import org.juhepay.merchant.api.dto.AppDTO;

import java.util.List;

/**
 * @ClassName AppService
 * @Description
 * @Author lily
 * @Date 2021/1/25 3:51 下午
 * @Version 1.0
 */
public interface AppService {
    /**
     * 商户下创建应用
     * @return
     */
    AppDTO createApp(Long merchantId, AppDTO app) throws BusinessException;

    /**
     * 查询商户下的应用列表 * @param merchantId * @return
     */
    List<AppDTO> queryAppByMerchant(Long merchantId) throws BusinessException;

    /**
     * 根据业务id查询应用
     * @param appId
     * @return
     */
    public AppDTO getAppId(String appId) throws BusinessException ;
}

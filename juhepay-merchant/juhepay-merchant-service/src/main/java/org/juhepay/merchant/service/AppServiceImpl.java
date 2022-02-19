package org.juhepay.merchant.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.annotation.Service;
import org.juhepay.common.domain.BusinessException;
import org.juhepay.common.domain.CommonErrorCode;
import org.juhepay.common.util.RandomStringUtil;
import org.juhepay.common.util.RandomUuidUtil;
import org.juhepay.merchant.api.AppService;
import org.juhepay.merchant.api.dto.AppDTO;
import org.juhepay.merchant.convert.AppCovert;
import org.juhepay.merchant.entity.App;
import org.juhepay.merchant.entity.Merchant;
import org.juhepay.merchant.mapper.AppMapper;
import org.juhepay.merchant.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName AppServiceImpl
 * @Description
 * @Author lily
 * @Date 2021/1/25 9:47 上午
 * @Version 1.0
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AppMapper appMapper;
    @Override
    public AppDTO createApp(Long merchantId, AppDTO appDTO) throws BusinessException {
        //校验商户是否存在
        Merchant merchant = merchantMapper.selectById(merchantId);
        if(merchant==null){
            throw  new BusinessException(CommonErrorCode.E_200002);
        }
        if(!"2".equals(merchant.getAuditStatus())){
            throw new BusinessException(CommonErrorCode.E_200003);
        }
        if(isExitAppName(appDTO.getAppName())){
            throw new BusinessException(CommonErrorCode.E_200004);
        }
        //上述所有条件都不成立，则保存应用信息
        appDTO.setAppId(RandomUuidUtil.getUUID());
        appDTO.setMerchantId(merchant.getId());
        App app = AppCovert.INSTANCE.dto2entity(appDTO);
        //添加应用
        appMapper.insert(app);
        return AppCovert.INSTANCE.entity2dto(app);
    }


    /**
     * 校验应用名是否已被使用
     * @param appName
     * @return
     */
    public boolean isExitAppName(String appName){
        Integer count = appMapper.selectCount(new QueryWrapper<App>().lambda().eq(App::getAppName, appName));
        return  count>0;
    }

    @Override
    public List<AppDTO> queryAppByMerchant(Long merchantId) throws BusinessException {
        List<App> apps = appMapper.selectList(new QueryWrapper<App>().lambda().eq(App::getMerchantId, merchantId));
        List<AppDTO> appDTOS = AppCovert.INSTANCE.listentity2dto(apps);
        return appDTOS;
    }


    @Override
    public AppDTO getAppId(String appId) throws BusinessException {
        App app = appMapper.selectOne(new QueryWrapper<App>().lambda().eq(App::getAppId, appId));
        return AppCovert.INSTANCE.entity2dto(app);
    }
}
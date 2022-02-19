package org.juhepay.merchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.juhepay.common.domain.BusinessException;
import org.juhepay.common.domain.CommonErrorCode;
import org.juhepay.merchant.util.SecurityUtil;
import org.juhepay.transaction.api.PayChannelService;
import org.juhepay.transaction.api.dto.PayChannelDTO;
import org.juhepay.transaction.api.dto.PayChannelParamDTO;
import org.juhepay.transaction.api.dto.PlatformChannelDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PlatformParamController
 * @Description
 * @Author lily
 * @Date 2021/1/25 4:55 下午
 * @Version 1.0
 */
@Api(value = "商户平台‐渠道和支付参数相关", tags = "商户平台‐渠道和支付参数", description = "商户平 台‐渠道和支付参数相关")
@Slf4j
@RestController
public class PlatformParamController {
    @Reference
    private PayChannelService payChannelService;
    @ApiOperation("获取平台服务类型")
    @GetMapping(value="/my/platform‐channels")
    public List<PlatformChannelDTO> queryPlatformChannel(){
        return payChannelService.queryPlatformChannel();
    }

    @ApiOperation("根据平台服务类型获取支付渠道列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "platformChannelCode", value = "服务类型编码", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value="/my/pay‐channels/platform‐channel/{platformChannelCode}")
    public List<PayChannelDTO> queryPayChannelByPlatformChannel(@PathVariable String                                                                                                      platformChannelCode){
        return payChannelService.queryPayChannelByPlatformChannel(platformChannelCode);
    }

    @ApiOperation("商户配置支付渠道参数")
    @ApiImplicitParam(name = "payChannelParamDTO", value = "支付渠道参数", required = true, dataType = "PayChannelParamDTO", paramType = "body")
    @RequestMapping(value = "/my/pay-channel-params",method = {RequestMethod.POST,RequestMethod.PUT})
    void createPayChannelParam(@RequestBody PayChannelParamDTO payChannelParamDTO){
        if(payChannelParamDTO == null || payChannelParamDTO.getChannelName() == null){
            throw new BusinessException(CommonErrorCode.E_300009);
        }
        //商户id
        Long merchantId = SecurityUtil.getMerchantId();
        payChannelParamDTO.setMerchantId(merchantId);
        payChannelService.savePayChannelParam(payChannelParamDTO);

    }

    @ApiOperation("根据应用和服务类型获取支付渠道参数列表")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "应用id",name = "appId",dataType = "String",paramType = "path"),
            @ApiImplicitParam(value = "服务类型代码",name = "platformChannel",dataType = "String",paramType = "path")
    })
    @GetMapping(value = "/my/pay-channel-params/apps/{appId}/platform-channels/{platformChannel}")
    public  List<PayChannelParamDTO> queryPayChannelParam(@PathVariable("appId")String appId,@PathVariable("platformChannel")String platformChannel){
        return payChannelService.queryPayChannelParamByAppAndPlatform(appId,platformChannel);
    }

    @ApiOperation("根据应用和服务类型和支付渠道获取单个支付渠道参数")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "应用id",name = "appId",dataType = "String",paramType = "path"),
            @ApiImplicitParam(value = "服务类型代码",name = "platformChannel",dataType = "String",paramType = "path"),
            @ApiImplicitParam(value = "支付渠道代码",name = "payChannel",dataType = "String",paramType = "path")
    })
    @GetMapping(value = "/my/pay-channel-params/apps/{appId}/platform-channels/{platformChannel}/pay-channels/{payChannel}")
    public  PayChannelParamDTO queryPayChannelParam(@PathVariable("appId")String appId,@PathVariable("platformChannel")String platformChannel,@PathVariable("payChannel") String payChannel){
        return payChannelService.queryParamByAppPlatformAndPayChannel(appId,platformChannel,payChannel);
    }
}

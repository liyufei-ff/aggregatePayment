package org.juhepay.merchant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.dubbo.config.annotation.Reference;
import org.juhepay.merchant.api.AppService;
import org.juhepay.merchant.api.dto.AppDTO;
import org.juhepay.merchant.util.SecurityUtil;
import org.juhepay.transaction.api.PayChannelService;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AppController
 * @Description
 * @Author lily
 * @Date 2021/1/25 10:08 上午
 * @Version 1.0
 */
@Api(value = "商户平台-应用管理",tags = "商户平台-应用相关",description = "商户平台-应用相关")
@RestController
public class AppController {

    //注入service (dubbo协议)
    @Reference
    private AppService appService;

    @Reference
    private PayChannelService payChannelService;

    @ApiOperation("商户创建应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "app",value = "应用信息",required = true,dataType = "AppDTO",paramType = "body")
    })
    @PostMapping("/my/createApp")
    public AppDTO createApp(@RequestBody AppDTO appDTO){
        Long merchantId = SecurityUtil.getMerchantId();
        return  appService.createApp(merchantId,appDTO);
    }

    @ApiOperation("根据appid 获取应用的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId",value = "商户应用id",required = true,dataType = "String",paramType = "path")
    })
    @GetMapping("/my/apps/{appId}")
    public AppDTO getAppId(@PathVariable String appId){
        return appService.getAppId(appId);
    }

    @ApiOperation("绑定服务类型")
    @PostMapping(value="/my/apps/{appId}/platform‐channels")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "应用id",name = "appId",dataType = "string",paramType ="path"),
            @ApiImplicitParam(value = "服务类型code",name = "platformChannelCodes",dataType = "string",paramType = "query")
    })
    public void bindPlatformForApp(@PathVariable("appId") String appId, @RequestParam("platformChannelCodes") String platformChannelCodes){
        payChannelService.bindPlatformChannelForApp(appId,platformChannelCodes);
    }

    @ApiOperation("查询应用是否绑定了某个服务类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appId", value = "应用appId", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "platformChannel", value = "服务类型", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/my/merchants/apps/platformchannels")
    public int queryAppBindPlatformChannel(@RequestParam String appId, @RequestParam String platformChannel){
        return payChannelService.queryAppBindPlatformChannel(appId,platformChannel);
    }

}
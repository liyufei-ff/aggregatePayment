package org.juhepay.merchant.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AppDTO
 * @Description
 * @Author lily
 * @Date 2021/1/25 3:50 下午
 * @Version 1.0
 */
@ApiModel(value = "AppDTO", description = "应用信息")
@Data
public class AppDTO implements Serializable {
    @ApiModelProperty("应用id，新增时无需传入")
    private String appId;

    @ApiModelProperty("应用名称")
    private String appName;

    @ApiModelProperty("商户id")
    private Long merchantId;

    @ApiModelProperty("应用公钥")
    private String publicKey;

    @ApiModelProperty("支付回调应用的url，创建时可不填")
    private String notifyUrl;
}
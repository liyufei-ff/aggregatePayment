package org.juhepay.common.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @ClassName RestErrorResponse
 * @Description
 * @Author lily
 * @Date 2021/1/24 9:39 上午
 * @Version 1.0
 */
@ApiModel(value = "RestErrorResponse", description = "错误响应参数包装")
@Data
public class RestErrorResponse {

    private String errCode;
    private String errMessage;

    public RestErrorResponse(String errCode, String errMessage){
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

}

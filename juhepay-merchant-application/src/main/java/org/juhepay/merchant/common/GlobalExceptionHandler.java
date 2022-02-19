package org.juhepay.merchant.common;

import org.juhepay.common.domain.BusinessException;
import org.juhepay.common.domain.CommonErrorCode;
import org.juhepay.common.domain.ErrorCode;
import org.juhepay.common.domain.RestErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName GlobalExceptionHandler
 * @Description
 * @Author lily
 * @Date 2021/1/24 9:45 上午
 * @Version 1.0
 */
@ControllerAdvice//与@Exceptionhandler配合使用实现全局异常处理
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //捕获Exception异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse processExcetion(HttpServletRequest request,
                                             HttpServletResponse response,
                                             Exception e){
        //解析异常信息
        //如果是系统自定义异常，直接取出errCode和errMessage
        if(e instanceof BusinessException){
            LOGGER.info(e.getMessage(),e);
            //解析系统自定义异常信息
            BusinessException businessException= (BusinessException) e;
            ErrorCode errorCode = businessException.getErrorCode();
            //错误代码
            int code = errorCode.getCode();
            //错误信息
            String desc = errorCode.getDesc();
            return new RestErrorResponse(String.valueOf(code),desc);
        }

        LOGGER.error("系统异常：",e);
        //统一定义为99999系统未知错误
        return new RestErrorResponse(String.valueOf(CommonErrorCode.UNKOWN.getCode()),CommonErrorCode.UNKOWN.getDesc());

    }
}
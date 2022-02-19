package org.juhepay.common.domain;

/**
 * @ClassName BusinessException
 * @Description 系统自定义异常
 * @Author lily
 * @Date 2021/1/24 9:30 上午
 * @Version 1.0
 */
public class BusinessException  extends  RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(){
        super();
    }


    public BusinessException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}

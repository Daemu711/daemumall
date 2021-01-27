package com.daemu.commons.exception;

import com.daemu.commons.api.IErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 * 统一业务异常处理
 */
@Getter
public class BusinessException extends RuntimeException{
    private IErrorCode errorCode;

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public BusinessException(IErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(),cause);
        this.errorCode = errorCode;
    }
    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

}

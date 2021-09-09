package com.daemu.commons.api;

import lombok.Getter;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 * 统一业务异常处理
 */
@Getter
public class BusinessException extends RuntimeException{
    private IErrorCode errorCode;
    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
        this.errorCode = new IErrorCode() {
            @Override
            public Integer getCode() {
                return    ResultCode.FAILED.getCode();
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }


    public BusinessException(int code, String msg) {
        super(msg);
        this.errorCode = new IErrorCode() {
            @Override
            public Integer getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return msg;
            }
        };
    }

    public BusinessException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public BusinessException(IErrorCode errorCode, Object[] args) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.args = args;
    }

    public BusinessException(IErrorCode errorCode, Object[] args, String message) {
        super(message);
        this.errorCode = errorCode;
        this.args = args;
    }

    public BusinessException(IErrorCode errorCode, Object[] args, String message, Throwable cause) {
        super( message, cause);
        this.errorCode = errorCode;
        this.args = args;
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
        this.errorCode = ResultCode.FAILED;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

}

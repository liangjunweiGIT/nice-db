package com.ls.demo.base.ex;

import com.ls.demo.base.ex.constants.BusinessExceptionEnumValue;

public class BusinessRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 2487325270865275804L;
    private String code;

    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(Throwable cause) {
        super(cause);
    }

    public BusinessRuntimeException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessRuntimeException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessRuntimeException(BusinessExceptionEnumValue value) {
        super(value.getMessage());
        this.code = value.getCode();
    }

    public BusinessRuntimeException(BusinessExceptionEnumValue value, Throwable cause) {
        super(value.getMessage(), cause);
        this.code = value.getCode();
    }

    public String getCode() {
        return code;
    }

}

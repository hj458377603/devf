package org.dream.bean.exception;

import org.dream.bean.errorcode.ErrorCode;

public class ParameterException extends RuntimeException {
    private ErrorCode error;

    public ErrorCode getError() {
        return error;
    }

    public void setError(ErrorCode error) {
        this.error = error;
    }

    public ParameterException(ErrorCode error) {
        super(error.getMsg());
        this.error = error;
    }
}
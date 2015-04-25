package org.dream.bean.response;

import org.dream.bean.errorcode.ErrorCode;

import com.google.gson.annotations.Expose;

/**
 * 返回实体
 */
public class ResultBean<T> {
    @Expose
    private ErrorCode errorCode;

    @Expose
    private T         data;

    public ResultBean(ErrorCode errorCode, T data) {
        this.errorCode = errorCode;
        this.data = data;
    }

    /**
     * @return the errorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

}

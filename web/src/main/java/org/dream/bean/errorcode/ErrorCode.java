package org.dream.bean.errorcode;

public enum ErrorCode {
    SYSTEM_SUCCESS("0","成功"),
    SYSTEM_ERROR("00001","系统异常"),
    PARA_EMAIL_ERROR("10001", "Email格式不正确"),
    PARA_PWD_ERROR("10002", "密码格式不正确");

    private String code;

    // 成员变量
    private String msg;

    // 构造方法
    private ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }
}
package org.dream.bean.errorcode;

public enum ErrorCode {
    SYSTEM_SUCCESS("0","成功"),
    SYSTEM_ERROR("00001","系统异常"),
    SYSTEM_400_ERROR("00002","请求出错"),
    SYSTEM_405_ERROR("00003","用来访问本页面的 HTTP谓词不被允许"),
    

    PARA_EMAIL_ERROR("PARA_0001", "Email格式不正确"),
    PARA_PWD_ERROR("PARA_0002", "密码格式不正确"),
    PARA_NICKNAME_ERROR("PARA_0003","昵称格式不正确"),
    
    
    ACCOUNT_UNAUTHORIZED_ERROR("10000","未登录"),
    ACCOUNT_LOGIN_ERROR("10003","登录失败"),
    ACCOUNT_REGISTER_ERROR("10004","注册失败"),
    ACCOUNT_EMAIL_DUPLICATE_ERROR("10005","邮箱已经被注册"),
    ACCOUNT_UPDATE_ERROR("10006","账户修改失败");
    
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

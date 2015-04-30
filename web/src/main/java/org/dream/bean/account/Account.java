package org.dream.bean.account;

import java.util.Date;

import com.google.gson.annotations.Expose;

/**
 * @since 2015-04-15 16:06:02
 */

public class Account {
    @Expose
    private int     id;

    @Expose
    private String  email;       // 用户名--email

    @Expose
    private String  nickName;    // 昵称

    private String  pwd;         // 密码（加密后保存）
    
    @Expose
    private String  imgUrl;      // 头像图片地址

    @Expose
    private String  accessToken; // 临时访问令牌（有效期一个月）

    @Expose
    private boolean accountState; // 账户状态：0:未激活;1:正常（已激活）;2:禁用

    @Expose
    private Date    createTime;  // 创建时间

    private Date    modifyTime;  // 最后修改时间

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean accountState() {
        return this.accountState;
    }

    public void accountState(boolean accountState) {
        this.accountState = accountState;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the accountState
     */
    public boolean isAccountState() {
        return accountState;
    }

    /**
     * @param accountState the accountState to set
     */
    public void setAccountState(boolean accountState) {
        this.accountState = accountState;
    }

    
}
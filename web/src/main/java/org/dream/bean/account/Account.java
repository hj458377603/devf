package org.dream.bean.account;

/**
 * @since 2015-04-15 16:06:02
 */

public class Account {
    private int     id;

    private String  email;           // 用户名--email

    private String  nickName;        // 昵称

    private String  pwd;             // 密码（加密后保存）

    private String  accessToken;     // 临时访问令牌（有效期一个月）

    private boolean accountState;    // 账户状态：0:未激活;1:正常（已激活）;2:禁用

    private String  createTime;      // 创建时间

    private String  modifyTime;      // 最后修改时间

    private int     modifyAccountId; // 修改人Id

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

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getModifyAccountId() {
        return this.modifyAccountId;
    }

    public void setModifyAccountId(int modifyAccountId) {
        this.modifyAccountId = modifyAccountId;
    }

}
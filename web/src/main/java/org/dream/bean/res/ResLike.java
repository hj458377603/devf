package org.dream.bean.res;

import com.google.gson.annotations.Expose;

/**
 * @since 2015-04-15 16:01:22
 */

public class ResLike {
    @Expose
    private int id;
    @Expose
    private int resId;     // 资源Id
    @Expose
    private int accountId; // 账户Id，该用户喜欢本资源

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

}
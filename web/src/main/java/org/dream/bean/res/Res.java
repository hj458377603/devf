package org.dream.bean.res;

import com.google.gson.annotations.Expose;

/**
 * @since 2015-04-15 16:01:22
 */

public class Res {
    @Expose
    private int     id;
    @Expose
    private int typeId;          // 资源类别：1、文字，2、图文
    @Expose
    private int     modifyAccountId; // 修改账户Id
    @Expose
    private String  modifyTime;      // 修改时间
    @Expose
    private boolean isDelete;        // 是否被删除，0：未删除，1：删除
    @Expose
    private int     createAccountId; // 创建账户Id
    @Expose
    private String  createTime;      // 创建时间

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int typeId() {
        return this.typeId;
    }

    public void typeId(int typeId) {
        this.typeId = typeId;
    }

    public int getModifyAccountId() {
        return this.modifyAccountId;
    }

    public void setModifyAccountId(int modifyAccountId) {
        this.modifyAccountId = modifyAccountId;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void isDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public int getCreateAccountId() {
        return this.createAccountId;
    }

    public void setCreateAccountId(int createAccountId) {
        this.createAccountId = createAccountId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
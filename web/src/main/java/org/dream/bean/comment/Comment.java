package org.dream.bean.comment;

/**
 * @since 2015-04-15 16:06:02
 */

public class Comment {
    private int     id;

    private int     resId;           // 被评论资源id

    private int     replyToAccountId; // 评论id(用于回复某人)

    private String  commentContent;  // 评论内容,140字以内

    private int     createAccountId; // 评论者账户Id

    private String  createTime;      // 创建时间

    private int     modifyAccountId; // 修改账户Id

    private String  modifyTime;      // 修改时间

    private boolean isDelete;        // 是否已删除，0:未删除，1：删除

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

    public int getReplyToAccountId() {
        return this.replyToAccountId;
    }

    public void setReplyToAccountId(int replyToAccountId) {
        this.replyToAccountId = replyToAccountId;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

}
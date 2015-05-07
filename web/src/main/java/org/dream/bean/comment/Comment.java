package org.dream.bean.comment;

import java.util.Date;

/**
 * @since 2015-04-15 16:06:02
 */

public class Comment {
    private int     id;

    private int     resId;           // 被评论资源id

    private int     replyToAccountId; // 评论id(用于回复某人)

    private String  commentContent;  // 评论内容,140字以内

    private int     createAccountId; // 评论者账户Id

    private Date    createTime;      // 创建时间

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

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void isDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

}
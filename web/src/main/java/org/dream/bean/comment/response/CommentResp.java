package org.dream.bean.comment.response;

import java.util.Date;

import com.google.gson.annotations.Expose;

/**
 * 评论返回值
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommentResp {
    @Expose
    private int    id;
    
    @Expose
    private int    replyToAccountId;

    @Expose
    private String replyToNickName;

    @Expose
    private String commentContent;

    @Expose
    private int    createAccountId;

    @Expose
    private Date   createTime;

    @Expose
    private String nickName;

    @Expose
    private String imgUrl;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the replyToAccountId
     */
    public int getReplyToAccountId() {
        return replyToAccountId;
    }

    /**
     * @param replyToAccountId the replyToAccountId to set
     */
    public void setReplyToAccountId(int replyToAccountId) {
        this.replyToAccountId = replyToAccountId;
    }

    /**
     * @return the replyToNickName
     */
    public String getReplyToNickName() {
        return replyToNickName;
    }

    /**
     * @param replyToNickName the replyToNickName to set
     */
    public void setReplyToNickName(String replyToNickName) {
        this.replyToNickName = replyToNickName;
    }

    /**
     * @return the commentContent
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * @param commentContent the commentContent to set
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * @return the createAccountId
     */
    public int getCreateAccountId() {
        return createAccountId;
    }

    /**
     * @param createAccountId the createAccountId to set
     */
    public void setCreateAccountId(int createAccountId) {
        this.createAccountId = createAccountId;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    
    
}

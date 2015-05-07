package org.dream.bean.res;

import java.util.Date;
import java.util.List;

import org.dream.bean.comment.response.CommentResp;
import org.dream.bean.res.response.ResLikeResp;

import com.google.gson.annotations.Expose;

/**
 * 通用资源bean
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommonRes {
    @Expose
    private int               id;

    @Expose
    private int               typeId;         // 资源类别：1、文字，2、图文

    @Expose
    private int               createAccountId; // 创建账户Id

    @Expose
    private Date              createTime;     // 创建时间

    @Expose
    private String            nickName;       // 用户昵称

    @Expose
    private String            imgUrl;         // 头像图片

    @Expose
    private String            txtContent;     // 文本内容

    @Expose
    private List<String>      imageResItems;  // 图片列表

    @Expose
    private List<ResLikeResp> resLikeList;    // 点赞者列表

    @Expose
    private List<CommentResp> commentRespList; // 评论列表

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
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
     * @return the txtContent
     */
    public String getTxtContent() {
        return txtContent;
    }

    /**
     * @param txtContent the txtContent to set
     */
    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    /**
     * @return the imageResItems
     */
    public List<String> getImageResItems() {
        return imageResItems;
    }

    /**
     * @param imageResItems the imageResItems to set
     */
    public void setImageResItems(List<String> imageResItems) {
        this.imageResItems = imageResItems;
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
     * @return the resLikeList
     */
    public List<ResLikeResp> getResLikeList() {
        return resLikeList;
    }

    /**
     * @param resLikeList the resLikeList to set
     */
    public void setResLikeList(List<ResLikeResp> resLikeList) {
        this.resLikeList = resLikeList;
    }

    /**
     * @return the commentRespList
     */
    public List<CommentResp> getCommentRespList() {
        return commentRespList;
    }

    /**
     * @param commentRespList the commentRespList to set
     */
    public void setCommentRespList(List<CommentResp> commentRespList) {
        this.commentRespList = commentRespList;
    }

}

package org.dream.bean;

import java.util.Date;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public class AppBean {
    private int    id;

    private String name;

    private String desUrl;

    private Date   createTime;

    private int    userId;

    private String devName;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the desUrl
     */
    public String getDesUrl() {
        return desUrl;
    }

    /**
     * @param desUrl the desUrl to set
     */
    public void setDesUrl(String desUrl) {
        this.desUrl = desUrl;
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
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the devName
     */
    public String getDevName() {
        return devName;
    }

    /**
     * @param devName the devName to set
     */
    public void setDevName(String devName) {
        this.devName = devName;
    }
}

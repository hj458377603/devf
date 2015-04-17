package org.dream.bean.res;

/**
 * @since 2015-04-15 16:01:22
 */

public class ImageResItem {
    private int    id;

    private int    imageResId;  // 图片资源Id(相册Id)

    private String imageItemUrl; // 图片地址

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getImageItemUrl() {
        return this.imageItemUrl;
    }

    public void setImageItemUrl(String imageItemUrl) {
        this.imageItemUrl = imageItemUrl;
    }

}
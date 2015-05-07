package org.dream.bean.res.request;

/**
 * 发布资源请求参数
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResReq {
    private String txtContent; // 文本内容

    private String imageUrls; // 图片列表

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
     * @return the imageUrls
     */
    public String getImageUrls() {
        return imageUrls;
    }

    /**
     * @param imageUrls the imageUrls to set
     */
    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }
    
    
}

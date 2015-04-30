package org.dream.bean.res;

import com.google.gson.annotations.Expose;

/**
 * @since 2015-04-15 16:01:22
 */

public class TextRes {
    @Expose
    private int    id;
    @Expose
    private String txtContent; // 文字内容，长度限制140

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxtContent() {
        return this.txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

}
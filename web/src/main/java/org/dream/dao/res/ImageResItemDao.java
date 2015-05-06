package org.dream.dao.res;

import java.util.List;

import org.dream.bean.res.ImageResItem;

/**
 * 图片资源
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ImageResItemDao {
    int add(ImageResItem imageResItem);

    List<String> queryListByImageResId(int imgResId);
}

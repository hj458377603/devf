package org.dream.service.res;

import java.util.List;

import org.dream.bean.res.ImageResItem;
import org.dream.dao.res.ImageResItemDao;
import org.dream.intf.res.ImageResItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片资源服务
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ImageResItemServiceImpl implements ImageResItemService {
    @Autowired
    ImageResItemDao imageResItemDao;

    public int add(ImageResItem imageResItem) {
        return imageResItemDao.add(imageResItem);
    }

    public List<String> queryListByImageResId(int imgResId) {
        return imageResItemDao.queryListByImageResId(imgResId);
    }
}

package org.dream.service.res;

import org.dream.bean.res.ImageRes;
import org.dream.dao.res.ImageResDao;
import org.dream.intf.res.ImageResService;
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
public class ImageResServiceImpl implements ImageResService{
    @Autowired
    ImageResDao imageResDao;

    public int add(ImageRes imageRes) {
        return imageResDao.add(imageRes);
    }

}

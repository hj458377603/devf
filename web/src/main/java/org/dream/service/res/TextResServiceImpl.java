package org.dream.service.res;

import org.dream.bean.res.TextRes;
import org.dream.dao.res.TextResDao;
import org.dream.intf.res.TextResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资源服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class TextResServiceImpl implements TextResService{
    @Autowired
    TextResDao textResDao;

    public int add(TextRes textRes) {
        return textResDao.add(textRes);
    }

}

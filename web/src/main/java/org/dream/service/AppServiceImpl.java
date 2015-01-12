package org.dream.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dream.bean.AppBean;
import org.dream.dao.AppMapper;
import org.dream.intf.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AppServiceImpl implements AppService {
    @Autowired
    AppMapper appMapper;

    public List<AppBean> queryAllAppBeans(int pageSize, int pageIndex) {
        int begin = (pageIndex - 1) * pageSize;
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("begin", begin);
        map.put("pageSize", pageSize);
        return appMapper.queryAllAppList(map);
    }

}

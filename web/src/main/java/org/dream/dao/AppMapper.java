package org.dream.dao;

import java.util.List;
import java.util.Map;

import org.dream.bean.AppBean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AppMapper {
    List<AppBean> queryAllAppList(Map<String, Object> map);
}

package org.dream.intf;

import java.util.List;

import org.dream.bean.AppBean;

/**
 * 应用信息服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AppService {
    /**
     * 功能描述: <br>
     * 分页查询应用信息
     *
     * @param pageSize
     * @param pageIndex
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    List<AppBean> queryAllAppBeans(int pageSize,int pageIndex);
}

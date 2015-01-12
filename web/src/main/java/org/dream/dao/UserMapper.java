package org.dream.dao;

import org.dream.bean.UserBean;

/**
 * 数据库访问类
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserMapper {
    UserBean queryByUserId(int userId);
    int save(UserBean userBean);
    int login(UserBean userBean);
}

/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: UserMapper.java
 * Author:   Administrator
 * Date:     2015-1-12 上午9:52:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
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
}

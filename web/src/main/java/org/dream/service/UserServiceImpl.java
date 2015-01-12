/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: HelloServiceImpl.java
 * Author:   Administrator
 * Date:     2015-1-7 上午9:26:13
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dream.service;

import org.dream.bean.UserBean;
import org.dream.dao.UserMapper;
import org.dream.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public UserBean queryByUserId(int userId) {
        UserBean userBean = userMapper.queryByUserId(userId);
        return userBean;
    }

    public int save(UserBean userBean) {        
        return userMapper.save(userBean);
    }

}

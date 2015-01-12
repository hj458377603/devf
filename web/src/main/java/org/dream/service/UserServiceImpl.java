package org.dream.service;

import org.dream.bean.UserBean;
import org.dream.dao.UserMapper;
import org.dream.intf.UserService;
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
    
    public int login(UserBean userBean) {
        return userMapper.login(userBean);
    }

}

package org.dream.intf;

import org.dream.bean.UserBean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserService {    
    UserBean queryByUserId(int userId);
    
    int save(UserBean userBean);
}

package org.dream.dao.account;

import java.util.HashMap;

import org.dream.bean.account.Account;

/**
 * 账户数据库访问类
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AccountDao {
    Account queryByUserNameAndPwd(HashMap<String, Object> map);
}

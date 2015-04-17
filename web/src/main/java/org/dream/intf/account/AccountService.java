package org.dream.intf.account;

import org.dream.bean.account.Account;

/**
 * 账户相关服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AccountService {
    Account login(String email,String pwd);
}

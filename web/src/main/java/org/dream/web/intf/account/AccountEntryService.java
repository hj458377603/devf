package org.dream.web.intf.account;

import org.dream.bean.account.Account;


public interface AccountEntryService {
    /**
     * 登录
     *
     * @param email
     * @param pwd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    Account login(String email,String pwd);
}

package org.dream.web.intf.account;

import java.io.InputStream;

import org.dream.bean.account.Account;
import org.dream.bean.response.ResultBean;

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
    ResultBean<String> login(String email, String pwd);

    /**
     * 注册
     * 
     * @param email
     * @param pwd
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> register(String email, String pwd);

    /**
     * 获取账户信息
     * 
     * @param accessToken
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Account> getAccountInfo(String accessToken);

    /**
     * 更新账户信息
     *
     * @param account
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> update(Account account);
        
    /**
     * 修改头像图片
     *
     * @param folder
     * @param inputstream
     * @param account
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<String> updateHeadImg(String folder,InputStream inputstream,Account account);
    
    /**
     * 注销账户
     *
     * @param accessToken
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> logout(String accessToken);
}

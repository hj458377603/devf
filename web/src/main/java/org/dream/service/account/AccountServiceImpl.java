package org.dream.service.account;

import java.util.HashMap;

import org.dream.bean.account.Account;
import org.dream.dao.account.AccountDao;
import org.dream.intf.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account login(String email, String pwd) {
        // pwd加密
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        map.put("pwd", pwd);
        return accountDao.queryByUserNameAndPwd(map);
    }
}

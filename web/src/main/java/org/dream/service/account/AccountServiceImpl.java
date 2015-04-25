package org.dream.service.account;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.dream.bean.account.Account;
import org.dream.dao.account.AccountDao;
import org.dream.intf.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account login(String email, String pwd) {        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        
        // pwd加密
        String md5Pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        map.put("pwd", md5Pwd);
        return accountDao.queryByUserNameAndPwd(map);
    }

    public boolean register(String email, String pwd) {
        Account account = new Account();
        account.setCreateTime(new Date());
        account.setEmail(email);
        String md5Pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        account.setPwd(md5Pwd);
        return accountDao.add(account) == 1 ? true : false;
    }

    public Account getAccountInfo(String email) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        return accountDao.queryByEmail(map);
    }

    public boolean isExist(String email) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("email", email);
        return accountDao.isExsit(map) == 1 ? true : false;
    }

    public boolean update(Account account) {
        if (!StringUtils.isEmpty(account.getPwd())) {
            String md5Pwd = DigestUtils.md5DigestAsHex(account.getPwd().getBytes());
            account.setPwd(md5Pwd);
        }
        account.setModifyTime(new Date());
        return accountDao.update(account) == 1 ? true : false;
    }
}

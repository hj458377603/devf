package org.dream.web.service.account;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.dream.bean.account.Account;
import org.dream.bean.constants.CommonConstants;
import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.intf.account.AccountService;
import org.dream.utils.cache.CacheUtils;
import org.dream.web.intf.account.AccountEntryService;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountEntryServiceImpl implements AccountEntryService {
    @Autowired
    AccountService   accountService;

    @Autowired
    ValidatorService validatorService;

    public ResultBean<String> login(String email, String pwd) {
        validatorService.validate(DataType.EMAIL, email);
        validatorService.validate(DataType.PWD, pwd);
        Account account = accountService.login(email, pwd);
        if (account == null) {
            throw new ParameterException(ErrorCode.ACCOUNT_LOGIN_ERROR);
        }

        String token = UUID.randomUUID().toString();
        CacheUtils.add(token, email, CommonConstants.CACHE_EXPIRE_MILI_SECONDS);

        return new ResultBean<String>(ErrorCode.SYSTEM_SUCCESS, token);
    }

    public ResultBean<Object> register(String email, String pwd) {
        validatorService.validate(DataType.EMAIL, email);
        validatorService.validate(DataType.PWD, pwd);

        // 账号是否已经被注册
        if (accountService.isExist(email)) {
            throw new ParameterException(ErrorCode.ACCOUNT_EMAIL_DUPLICATE_ERROR);
        }
        boolean res = accountService.register(email, pwd);
        if (!res) {
            throw new ParameterException(ErrorCode.ACCOUNT_REGISTER_ERROR);
        }

        return new ResultBean<Object>(ErrorCode.SYSTEM_SUCCESS, null);
    }

    public ResultBean<Account> getAccountInfo(String email) {
        Account account = accountService.getAccountInfo(email);
        if (account == null) {
            throw new ParameterException(ErrorCode.ACCOUNT_LOGIN_ERROR);
        }

        return new ResultBean<Account>(ErrorCode.SYSTEM_SUCCESS, account);
    }

    public ResultBean<Object> update(Account account) {
        if (account != null) {
            validatorService.validate(DataType.EMAIL, account.getEmail());
            
            if (!StringUtils.isEmpty(account.getNickName())) {
                validatorService.validate(DataType.NICKNAME, account.getNickName());
            }
            if (!StringUtils.isEmpty(account.getPwd())) {
                validatorService.validate(DataType.PWD, account.getPwd());
            }
            boolean res = accountService.update(account);
            if (!res) {
                throw new ParameterException(ErrorCode.ACCOUNT_UPDATE_ERROR);
            }
        } else {
            throw new ParameterException(ErrorCode.ACCOUNT_UPDATE_ERROR);
        }
        return new ResultBean<Object>(ErrorCode.SYSTEM_SUCCESS, null);
    }

}

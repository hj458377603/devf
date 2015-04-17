package org.dream.web.service.account;

import org.dream.bean.account.Account;
import org.dream.intf.account.AccountService;
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

    public Account login(String email, String pwd) {
        validatorService.validate(DataType.EMAIL, email);
        validatorService.validate(DataType.PWD, pwd);
        
        return accountService.login(email, pwd);
    }

}

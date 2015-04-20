package org.dream.web.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.account.Account;
import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.bean.response.TraceId;
import org.dream.utils.UuidUtil;
import org.dream.web.controller.base.BaseController;
import org.dream.web.controller.error.ErrorController;
import org.dream.web.intf.account.AccountEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountEntryService   accountEntryService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(String email, String pwd, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        try {
            Account res = accountEntryService.login(email, pwd);
            result = new ResultBean<Account>(ErrorCode.SYSTEM_SUCCESS, res);
        } catch (ParameterException e) {
            TraceId traceId = new TraceId(UuidUtil.getUUID());
            result = new ResultBean<TraceId>(e.getError(), traceId);
            
            logger.warn("failed:"+e.getError().getMsg());
        }
        ajaxJson(response, result);
    }
}

package org.dream.web.controller.res;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.account.Account;
import org.dream.bean.constants.ConfigConstants;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.res.request.ResReq;
import org.dream.bean.response.ResultBean;
import org.dream.web.controller.base.BaseController;
import org.dream.web.intf.res.ResEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源访问控制器
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/res")
public class ResController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ResController.class);

    @Autowired
    ResEntryService       resEntryService;

    @RequestMapping("/private/getMyRes")
    public void getMyRes(HttpServletRequest request, HttpServletResponse response) {
        ResultBean<?> result = null;
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        try {
            result = resEntryService.queryMyRes(account.getEmail());
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    @RequestMapping("/private/addTextRes")
    public void addTextRes(ResReq resBeanReq, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        try {
            // 获取账号
            result = resEntryService.addTextRes(resBeanReq, account.getId());
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    @RequestMapping("/private/addImageRes")
    public void addImageRes(ResReq resBeanReq, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        // 获取账号
        try {
            result = resEntryService.addImageRes(resBeanReq, account.getId());
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    @RequestMapping("/private/addResLike")
    public void addResLike(Integer resId, HttpServletRequest request, HttpServletResponse response) {
        ResultBean<?> result = null;
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        if (resId == null) {
            resId = 0;
        }
        // 获取账号
        try {
            result = resEntryService.addResLike(resId, account.getId());
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }
}

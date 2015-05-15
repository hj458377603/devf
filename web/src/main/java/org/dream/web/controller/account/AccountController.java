package org.dream.web.controller.account;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.account.Account;
import org.dream.bean.constants.ConfigConstants;
import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.web.controller.base.BaseController;
import org.dream.web.intf.account.AccountEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

    /**
     * 登录
     * 
     * @param email
     * @param pwd
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(String email, String pwd, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        try {
            result = accountEntryService.login(email, pwd);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    /**
     * 获取账户详情
     * 
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/private/getAccountInfo")
    public void getAccountInfo(HttpServletRequest request, HttpServletResponse response) {
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        ResultBean<?> result = null;
        try {
            result = accountEntryService.getAccountInfo(account.getEmail());
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    /**
     * 注册
     * 
     * @param email
     * @param pwd
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(String email, String pwd, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        try {
            result = accountEntryService.register(email, pwd);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }

        ajaxJson(response, result);
    }

    /**
     * 修改账户信息
     * 
     * @param account
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/private/updateAccount", method = RequestMethod.POST)
    public void updateAccount(Account account, HttpServletRequest request,
            HttpServletResponse response) {
        ResultBean<?> result = null;
        Account tempAccount = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        account.setEmail(tempAccount.getEmail());
        try {
            result = accountEntryService.update(account);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }

        ajaxJson(response, result);
    }

    /**
     * 修改头像图片
     * 
     * @param account
     * @param request
     * @param response
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/private/modifyHeadImg")
    public void modifyHeadImg(Account account, HttpServletRequest request,
            HttpServletResponse response) {
        Account tempAccount = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        account.setEmail(tempAccount.getEmail());
        ResultBean<?> result = null;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");// 获得文件
        // String filename = multipartFile.getOriginalFilename();// 获得文件名
        InputStream inputstream;
        try {
            inputstream = multipartFile.getInputStream();// 输入流
            String folderString = request.getSession().getServletContext()
                    .getRealPath(ConfigConstants.FILE_FOLDER);
            result = accountEntryService.updateHeadImg(folderString, inputstream, account);
        } catch (IOException e) {
            result = new ResultBean<Object>(ErrorCode.ACCOUNT_MODIFY_IMG_ERROR, null);
            logger.error("failed:" + e);
        }
        ajaxJson(response, result);
    }

    /**
     * 账户注销
     * 
     * @param account
     * @param request
     * @param response
     * @throws IOException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/private/logout")
    public void logout(Account account, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ResultBean<?> result = null;
        String accessToken = request.getHeader(ConfigConstants.ACCESS_TOKEN);
        try {
            result = accountEntryService.logout(accessToken);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }
}

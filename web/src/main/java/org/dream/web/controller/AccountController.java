package org.dream.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.UserBean;
import org.dream.intf.UserService;
import org.dream.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 测试controller
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 获取用户信息
     *
     * @param userId
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/getUserInfo/{userId}")
    public void getUserInfo(@PathVariable Integer userId, HttpServletRequest request,
            HttpServletResponse response) {
        UserBean userBean = userService.queryByUserId(userId);
        String userString = gson.toJson(userBean);
        ajaxJson(response, userString);
    }

    /**
     * 注册用户
     *
     * @param userBean
     * @param request
     * @param response
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addUser(UserBean userBean, HttpServletRequest request, HttpServletResponse response) {
        int res = userService.save(userBean);
        ajaxJson(response, res + "");
    }
}

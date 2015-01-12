/*
 * Copyright (C), 2002-2015, �����׹������������޹�˾
 * FileName: TestController.java
 * Author:   Administrator
 * Date:     2015-1-7 ����9:30:47
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
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
 * ����controller
 * 
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * ��ȡ�û���Ϣ
     *
     * @param userId
     * @param request
     * @param response
     * @see [�����/����](��ѡ)
     * @since [��Ʒ/ģ��汾](��ѡ)
     */
    @RequestMapping("/getUserInfo/{userId}")
    public void getUserInfo(@PathVariable Integer userId, HttpServletRequest request,
            HttpServletResponse response) {
        UserBean userBean = userService.queryByUserId(userId);
        String userString = gson.toJson(userBean);
        ajaxJson(response, userString);
    }

    /**
     * ע���û�
     *
     * @param userBean
     * @param request
     * @param response
     * @see [�����/����](��ѡ)
     * @since [��Ʒ/ģ��汾](��ѡ)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addUser(UserBean userBean, HttpServletRequest request, HttpServletResponse response) {
        int res = userService.save(userBean);
        ajaxJson(response, res + "");
    }
}

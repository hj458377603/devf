/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: AppController.java
 * Author:   Administrator
 * Date:     2015-1-12 下午1:10:59
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dream.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.AppBean;
import org.dream.intf.AppService;
import org.dream.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/app")
public class AppController extends BaseController {
    @Autowired
    AppService appService;
    
    @RequestMapping("/getAppList/{pageIndex}")
    public void getAppList(@PathVariable Integer pageIndex, HttpServletRequest request,
            HttpServletResponse response) {
        List<AppBean> appBeans = appService.queryAllAppBeans();
        String appsJsonStr = gson.toJson(appBeans);
        ajaxJson(response, appsJsonStr);
    }
}

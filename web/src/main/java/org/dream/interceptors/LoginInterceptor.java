/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: LoginInterceptor.java
 * Author:   Administrator
 * Date:     2015-4-9 下午5:11:13
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dream.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.dream.utils.cache.Cache;
import org.dream.utils.cache.CacheUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            Cache cache = CacheUtils.getCache(token);
            if (cache != null && cache.getValue() != null) {
                System.out.println("accessToken=========>" + cache.getValue());
                return true;
            }

        }

        ajaxJson(response, "Unauthorized");
        return false;
    }

    private void ajaxJson(HttpServletResponse response, String content) {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            // 日志
        }
    }
}
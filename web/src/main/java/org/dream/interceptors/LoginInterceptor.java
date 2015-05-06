package org.dream.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.dream.bean.account.Account;
import org.dream.bean.constants.ConfigConstants;
import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.response.ResponseBean;
import org.dream.bean.response.ResultBean;
import org.dream.utils.cache.Cache;
import org.dream.utils.cache.CacheUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 登录拦截器
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                                     .excludeFieldsWithoutExposeAnnotation()
                                     .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String token = request.getHeader(ConfigConstants.ACCESS_TOKEN);
        if (!StringUtils.isEmpty(token)) {
            Cache cache = CacheUtils.getCache(token);
            // 防止修改Account字段，导致Account转换失败
            if (cache != null && cache.getValue() != null && cache.getValue() instanceof Account) {
                request.setAttribute(ConfigConstants.ACCOUNT, cache.getValue());
                System.out.println(ConfigConstants.ACCOUNT + "=========>" + cache.getValue());
                return true;
            }
        }

        ResultBean<Object> result = new ResultBean<Object>(ErrorCode.ACCOUNT_UNAUTHORIZED_ERROR,
                null);
        ajaxJson(response, result);
        return false;
    }

    private void ajaxJson(HttpServletResponse response, String content) {
        response.setContentType("application/json;charset=utf-8");
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

    /**
     * 功能描述: <br>
     * 输出JSON，返回null
     * 
     * @param response
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void ajaxJson(HttpServletResponse response, ResultBean resultBean) {
        String res = null;
        String msg = null;
        ResponseBean responseBean = null;
        if (resultBean != null) {
            if (resultBean.getErrorCode() != null) {
                res = resultBean.getErrorCode().getCode();
                msg = resultBean.getErrorCode().getMsg();
            }
            responseBean = new ResponseBean(res, msg, resultBean.getData());
        }

        String result = gson.toJson(responseBean);
        ajaxJson(response, result);
    }
}

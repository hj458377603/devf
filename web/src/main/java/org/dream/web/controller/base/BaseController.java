package org.dream.web.controller.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.dream.bean.response.ResponseBean;
import org.dream.bean.response.ResultBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 基础controller
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseController {
    protected static Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                                       .excludeFieldsWithoutExposeAnnotation().serializeNulls()
                                       .setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * 功能描述：根据Object输出JSON字符串
     */
    public String getJson(Object jsonObject) {
        return gson.toJson(jsonObject);
    }

    /**
     * 根据字符串输出JSON，返回null
     * 
     * @param content
     * @param type
     * @return
     */
    public void ajaxJson(HttpServletResponse response, String content) {
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

    /**
     * 功能描述: <br>
     * 输出JSON，返回null
     * 
     * @param response
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void ajaxJson(HttpServletResponse response, ResultBean resultBean) {
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

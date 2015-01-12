package org.dream.web.controller.base;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * ����controller
 *
 * @author Administrator
 * @see [�����/����]����ѡ��
 * @since [��Ʒ/ģ��汾] ����ѡ��
 */
public class BaseController {
    protected static Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    /**
     * ��������������Object���JSON�ַ���
     */
    public String getJson(Object jsonObject) {
        return gson.toJson(jsonObject);
    }
    
    /**
     * �����ַ������JSON������null
     * 
     * @param content
     * @param type
     * @return
     */
    public void ajaxJson(HttpServletResponse response, String content) {
        try {
            response.setContentType("text/plain;charset=UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (Exception e) {
            // ��־
        }
    }

}

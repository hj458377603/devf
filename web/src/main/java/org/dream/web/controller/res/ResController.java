package org.dream.web.controller.res;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.constants.ConfigConstants;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.web.controller.account.AccountController;
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
        String email = request.getAttribute(ConfigConstants.EMAIL_ATTRIBUTE).toString();
        try {
            result = resEntryService.queryMyRes(email);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }
}

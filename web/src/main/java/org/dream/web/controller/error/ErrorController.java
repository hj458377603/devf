package org.dream.web.controller.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.response.ResultBean;
import org.dream.bean.response.TraceId;
import org.dream.utils.UuidUtil;
import org.dream.web.controller.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/exception", method = { RequestMethod.GET, RequestMethod.POST })
    public void exception(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        errorHandle(ErrorCode.SYSTEM_ERROR, httpServletRequest, response);
    }

    @RequestMapping(value = "/400", method = { RequestMethod.GET, RequestMethod.POST })
    public void error400(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        errorHandle(ErrorCode.SYSTEM_400_ERROR, httpServletRequest, response);
    }

    @RequestMapping(value = "/405", method = { RequestMethod.GET, RequestMethod.POST })
    public void error405(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        errorHandle(ErrorCode.SYSTEM_405_ERROR, httpServletRequest, response);
    }

    private void errorHandle(ErrorCode errorCode, HttpServletRequest httpServletRequest,
            HttpServletResponse response) {        
        Exception exception = (Exception) httpServletRequest
                .getAttribute("javax.servlet.error.exception");
        
        String traceIdString = UuidUtil.getUUID();
        TraceId traceId = new TraceId(traceIdString);
        if (exception != null) {
            logger.error("traceId:[" + traceIdString + "]" + exception.getMessage(), exception);
        }
        ResultBean<TraceId> result = new ResultBean<TraceId>(errorCode, traceId);
        ajaxJson(response, result);
    }
}

package org.dream.web.controller.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dream.bean.account.Account;
import org.dream.bean.comment.Comment;
import org.dream.bean.constants.ConfigConstants;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.web.controller.base.BaseController;
import org.dream.web.intf.comment.CommentEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评论控制器
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    CommentEntryService   commentEntryService;

    @RequestMapping("/private/add")
    public void addComment(Comment comment, HttpServletRequest request, HttpServletResponse response) {
        ResultBean<?> result = null;
        Account account = (Account) request.getAttribute(ConfigConstants.ACCOUNT);
        try {
            result = commentEntryService.addComment(comment, account);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }

    @RequestMapping("/private/queryList")
    public void queryList(Integer resId, HttpServletRequest request, HttpServletResponse response) {
        ResultBean<?> result = null;
        // Account account = (Account)
        // request.getAttribute(ConfigConstants.ACCOUNT);
        try {
            result = commentEntryService.queryList(resId);
        } catch (ParameterException e) {
            result = new ResultBean<Object>(e.getError(), null);
            logger.debug("failed:" + e.getError().getMsg());
        }
        ajaxJson(response, result);
    }
}

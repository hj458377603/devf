package org.dream.web.service.comment;

import java.util.Date;
import java.util.List;

import org.dream.bean.account.Account;
import org.dream.bean.comment.Comment;
import org.dream.bean.comment.response.CommentResp;
import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.exception.ParameterException;
import org.dream.bean.response.ResultBean;
import org.dream.intf.comment.CommentService;
import org.dream.web.intf.comment.CommentEntryService;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论服务
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CommentEntryServiceImpl implements CommentEntryService {
    @Autowired
    CommentService   commentService;

    @Autowired
    ValidatorService validatorService;

    /**
     * 增加评论
     * 
     * @param comment
     * @param account
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public ResultBean<Object> addComment(Comment comment, Account account) {
        validatorService.validate(DataType.COMMENT, comment.getCommentContent());

        Date date = new Date();
        comment.setCreateAccountId(account.getId());
        comment.setCreateTime(date);

        // 校验resId,replyToAccountId
        boolean res = commentService.add(comment);
        if (res) {
            return new ResultBean<Object>(ErrorCode.SYSTEM_SUCCESS, null);
        } else {
            throw new ParameterException(ErrorCode.COMMENT_ADD_ERROR);
        }
    }
    
    /**
     * 查询评论
     * 
     * @param resId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public ResultBean<List<CommentResp>> queryList(int resId) {
        List<CommentResp> commentRespList = commentService.queryList(resId);
        return new ResultBean<List<CommentResp>>(ErrorCode.SYSTEM_SUCCESS, commentRespList);
    }

}

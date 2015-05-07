package org.dream.web.intf.comment;

import java.util.List;

import org.dream.bean.account.Account;
import org.dream.bean.comment.Comment;
import org.dream.bean.comment.response.CommentResp;
import org.dream.bean.response.ResultBean;

/**
 * 评论服务接口
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CommentEntryService {
    /**
     * 增加评论
     * 
     * @param comment
     * @param account
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> addComment(Comment comment, Account account);

    /**
     * 查询评论
     * 
     * @param resId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<List<CommentResp>> queryList(int resId);
}

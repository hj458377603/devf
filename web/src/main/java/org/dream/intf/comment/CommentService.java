package org.dream.intf.comment;

import java.util.List;

import org.dream.bean.comment.Comment;
import org.dream.bean.comment.response.CommentResp;

/**
 * 评论服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CommentService {
    boolean add(Comment comment);
    
    List<CommentResp> queryList(int resId);
}

package org.dream.dao.comment;

import java.util.List;

import org.dream.bean.comment.Comment;
import org.dream.bean.comment.response.CommentResp;

/**
 * 评论数据库访问类
 * 
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CommentDao {
    int add(Comment comment);

    List<CommentResp> queryList(int resId);
}

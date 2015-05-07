package org.dream.service.comment;

import java.util.List;

import org.dream.bean.comment.Comment;
import org.dream.bean.comment.response.CommentResp;
import org.dream.dao.comment.CommentDao;
import org.dream.intf.comment.CommentService;
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
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;

    public boolean add(Comment comment) {
        return commentDao.add(comment) == 1;
    }

    public List<CommentResp> queryList(int resId) {
        return commentDao.queryList(resId);
    }

}

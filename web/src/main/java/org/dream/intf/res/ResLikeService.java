package org.dream.intf.res;

import java.util.List;

import org.dream.bean.res.ResLike;
import org.dream.bean.res.response.ResLikeResp;

/**
 * 资源点赞服务接口
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ResLikeService {
    List<ResLikeResp> queryList(int resId);

    int add(ResLike resLike);

    boolean hasLike(int resId, int accountId);

}

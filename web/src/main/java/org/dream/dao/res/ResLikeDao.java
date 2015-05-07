package org.dream.dao.res;

import java.util.List;
import java.util.Map;

import org.dream.bean.res.ResLike;
import org.dream.bean.res.response.ResLikeResp;

/**
 * 资源数据访问对象
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ResLikeDao {
    List<ResLikeResp> queryList(int resId);

    int add(ResLike resLike);

    int hasLike(Map<String, Integer> map);
}

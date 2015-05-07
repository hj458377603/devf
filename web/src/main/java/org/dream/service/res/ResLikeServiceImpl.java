package org.dream.service.res;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dream.bean.res.ResLike;
import org.dream.bean.res.response.ResLikeResp;
import org.dream.dao.res.ResLikeDao;
import org.dream.intf.res.ResLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资源点赞服务
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ResLikeServiceImpl implements ResLikeService {
    @Autowired
    ResLikeDao resLikeDao;

    public List<ResLikeResp> queryList(int resId) {
        return resLikeDao.queryList(resId);
    }

    public int add(ResLike resLike) {
        return resLikeDao.add(resLike);
    }

    public boolean hasLike(int resId, int accountId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("resId", resId);
        map.put("accountId", accountId);
        return resLikeDao.hasLike(map) > 0 ? true : false;
    }
}

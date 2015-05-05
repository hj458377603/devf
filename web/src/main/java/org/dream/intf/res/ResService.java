package org.dream.intf.res;

import java.util.List;

import org.dream.bean.res.CommonRes;
import org.dream.bean.res.Res;

/**
 * 资源服务接口
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ResService {
    List<CommonRes> queryMyRes(String email);
    
    int add(Res res);
}

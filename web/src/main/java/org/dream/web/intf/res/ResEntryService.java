package org.dream.web.intf.res;

import java.util.List;

import org.dream.bean.res.CommonRes;
import org.dream.bean.res.request.ResBeanReq;
import org.dream.bean.response.ResultBean;

/**
 * 
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ResEntryService {
    /**
     * 查询我的资源
     * 
     * @param email
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<List<CommonRes>> queryMyRes(String email);

    /**
     * 增加文本资源
     *
     * @param resBeanReq
     * @param accountId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> addTextRes(ResBeanReq resBeanReq, int accountId);

    /**
     * 增加图片资源
     *
     * @param resBeanReq
     * @param accountId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    ResultBean<Object> addImageRes(ResBeanReq resBeanReq, int accountId);

}

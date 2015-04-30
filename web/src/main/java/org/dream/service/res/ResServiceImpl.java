package org.dream.service.res;

import java.util.List;

import org.dream.bean.res.CommonRes;
import org.dream.dao.res.ResDao;
import org.dream.intf.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 资源服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ResServiceImpl implements ResService{
    @Autowired
    ResDao resDao;
    
    public List<CommonRes> queryMyRes(String email) {
        return resDao.queryMyRes(email);
    }

}

package org.dream.web.service.res;

import java.util.List;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.res.CommonRes;
import org.dream.bean.response.ResultBean;
import org.dream.intf.res.ResService;
import org.dream.web.intf.res.ResEntryService;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.ValidatorService;
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
public class ResEntryServiceImp implements ResEntryService {
    @Autowired
    ResService       resService;

    @Autowired
    ValidatorService validatorService;

    public ResultBean<List<CommonRes>> queryMyRes(String email){
        validatorService.validate(DataType.EMAIL, email);
        List<CommonRes> result = resService.queryMyRes(email);

        return new ResultBean<List<CommonRes>>(ErrorCode.SYSTEM_SUCCESS, result);
    }

}

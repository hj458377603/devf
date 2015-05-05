package org.dream.web.service.res;

import java.util.Date;
import java.util.List;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.res.CommonRes;
import org.dream.bean.res.Res;
import org.dream.bean.res.TextRes;
import org.dream.bean.response.ResultBean;
import org.dream.intf.res.ResService;
import org.dream.intf.res.TextResService;
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
    TextResService   textResService;

    @Autowired
    ValidatorService validatorService;

    public ResultBean<List<CommonRes>> queryMyRes(String email) {
        validatorService.validate(DataType.EMAIL, email);
        List<CommonRes> result = resService.queryMyRes(email);

        return new ResultBean<List<CommonRes>>(ErrorCode.SYSTEM_SUCCESS, result);
    }

    public ResultBean<Integer> addTextRes(CommonRes commonRes) {
        // 插入资源表
        Date date = new Date();
        Res res = new Res();
        res.setCreateAccountId(commonRes.getCreateAccountId());
        res.setCreateTime(date);
        res.setModifyAccountId(commonRes.getCreateAccountId());
        res.setModifyTime(date);
        resService.add(res);

        // 插入文本资源表
        TextRes textRes = new TextRes();
        textRes.setId(res.getId());
        textRes.setTxtContent(commonRes.getTxtContent());
        textResService.add(textRes);

        return new ResultBean<Integer>(ErrorCode.SYSTEM_SUCCESS, res.getId());// res.getId()获取主键Id
    }

}

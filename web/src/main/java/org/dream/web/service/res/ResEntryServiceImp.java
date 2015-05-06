package org.dream.web.service.res;

import java.util.Date;
import java.util.List;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.res.CommonRes;
import org.dream.bean.res.ImageRes;
import org.dream.bean.res.ImageResItem;
import org.dream.bean.res.Res;
import org.dream.bean.res.ResType;
import org.dream.bean.res.TextRes;
import org.dream.bean.res.request.ResBeanReq;
import org.dream.bean.response.ResultBean;
import org.dream.intf.res.ImageResItemService;
import org.dream.intf.res.ImageResService;
import org.dream.intf.res.ResService;
import org.dream.intf.res.TextResService;
import org.dream.web.intf.res.ResEntryService;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    ResService          resService;

    @Autowired
    TextResService      textResService;

    @Autowired
    ImageResService     imageResService;

    @Autowired
    ImageResItemService imageResItemService;

    @Autowired
    ValidatorService    validatorService;

    public ResultBean<List<CommonRes>> queryMyRes(String email) {
        validatorService.validate(DataType.EMAIL, email);
        List<CommonRes> result = resService.queryMyRes(email);

        // 设置图片列表
        if (result != null && result.size() > 0) {
            for (CommonRes commonRes : result) {
                if (commonRes != null && commonRes.getTypeId() == ResType.Image.getValue()) {
                    List<String> urls = imageResItemService
                            .queryListByImageResId(commonRes.getId());
                    commonRes.setImageResItems(urls);
                }
            }
        }
        return new ResultBean<List<CommonRes>>(ErrorCode.SYSTEM_SUCCESS, result);
    }

    public ResultBean<Object> addTextRes(ResBeanReq resBeanReq, int accountId) {
        // 输入校验...
        validatorService.validate(DataType.TEXTCONTENT, resBeanReq.getTxtContent());

        // 插入资源表
        Date date = new Date();
        Res res = new Res();
        res.setCreateAccountId(accountId);
        res.setCreateTime(date);
        res.setModifyAccountId(accountId);
        res.setModifyTime(date);
        res.setTypeId(ResType.Text.getValue());
        resService.add(res);

        // 插入文本资源表
        TextRes textRes = new TextRes();
        textRes.setId(res.getId());// res.getId()获取主键Id
        textRes.setTxtContent(resBeanReq.getTxtContent());
        textResService.add(textRes);

        return new ResultBean<Object>(ErrorCode.SYSTEM_SUCCESS, null);
    }

    // 事务
    @Transactional(propagation = Propagation.REQUIRED)
    public ResultBean<Object> addImageRes(ResBeanReq resBeanReq, int accountId) {
        // 输入校验...
        validatorService.validate(DataType.IMAGEURLS, resBeanReq.getImageUrls());

        // 插入资源表
        Date date = new Date();
        Res res = new Res();
        res.setCreateAccountId(accountId);
        res.setCreateTime(date);
        res.setModifyAccountId(accountId);
        res.setModifyTime(date);
        res.setTypeId(ResType.Image.getValue());
        resService.add(res);

        // 插入图片资源表
        ImageRes imageRes = new ImageRes();
        imageRes.setId(res.getId());// res.getId()获取主键Id
        imageRes.setTxtContent(resBeanReq.getTxtContent());
        imageResService.add(imageRes);

        // 插入图片资源子表
        ImageResItem imageResItem = null;
        String[] imageUrls = resBeanReq.getImageUrls().split(",");

        for (String url : imageUrls) {
            imageResItem = new ImageResItem();
            imageResItem.setImageResId(imageRes.getId());
            imageResItem.setImageItemUrl(url);
            imageResItemService.add(imageResItem);
        }

        return new ResultBean<Object>(ErrorCode.SYSTEM_SUCCESS, null);
    }

}

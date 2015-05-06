package org.dream.web.service.validator;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.web.intf.validator.AbstractValidator;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.rule.UrlsValidateRule;
import org.springframework.stereotype.Service;

/**
 * 图片路径验证
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ImageUrlsValidator extends AbstractValidator {

    public DataType getSupportedType() {
        return DataType.IMAGEURLS;
    }

    public ImageUrlsValidator() {
        this.registerRule(new UrlsValidateRule(128, 9), ErrorCode.PARA_IMAGEURL_ERROR);
    }

}

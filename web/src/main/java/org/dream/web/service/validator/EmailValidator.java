package org.dream.web.service.validator;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.web.intf.validator.AbstractValidator;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.rule.MaxLengthValidateRule;
import org.dream.web.intf.validator.rule.RegxValidateRule;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class EmailValidator extends AbstractValidator {

    public DataType getSupportedType() {
        return DataType.EMAIL;
    }

    public EmailValidator() {
        this.registerRule(new RegxValidateRule("\\w+([-.]\\w+)*@\\w+([-.]\\w+)*"),ErrorCode.PARA_EMAIL_ERROR);
        this.registerRule(new MaxLengthValidateRule(128), ErrorCode.PARA_EMAIL_ERROR);
    }

}

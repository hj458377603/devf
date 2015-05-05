package org.dream.web.service.validator;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.web.intf.validator.AbstractValidator;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.rule.RegxValidateRule;

/**
 * 资源类型校验
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ResTypeIdValidator extends AbstractValidator {
    public DataType getSupportedType() {
        return DataType.TYPEID;
    }

    public ResTypeIdValidator() {
        this.registerRule(new RegxValidateRule("[1|2]"), ErrorCode.PARA_PWD_ERROR);
    }
}

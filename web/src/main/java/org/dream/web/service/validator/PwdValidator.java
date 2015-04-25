package org.dream.web.service.validator;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.web.intf.validator.AbstractValidator;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.rule.MaxLengthValidateRule;
import org.dream.web.intf.validator.rule.MinLengthValidateRule;
import org.dream.web.intf.validator.rule.NotNullValidateRule;
import org.springframework.stereotype.Service;

@Service
public class PwdValidator extends AbstractValidator{

    
    public DataType getSupportedType() {
        return DataType.PWD;
    }
    
    public PwdValidator(){
        this.registerRule(new NotNullValidateRule(),ErrorCode.PARA_PWD_ERROR);
        this.registerRule(new MaxLengthValidateRule(20), ErrorCode.PARA_PWD_ERROR);
        this.registerRule(new MinLengthValidateRule(6), ErrorCode.PARA_PWD_ERROR);
    }
}

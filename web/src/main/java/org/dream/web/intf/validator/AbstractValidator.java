package org.dream.web.intf.validator;

import java.util.HashMap;
import java.util.Map;

import org.dream.bean.errorcode.ErrorCode;
import org.dream.bean.exception.ParameterException;
import org.dream.web.intf.validator.rule.ValidateRule;

public abstract class AbstractValidator<T> implements Validator<T> {

    protected Map<ValidateRule, ErrorCode> validateRuleList = new HashMap<ValidateRule, ErrorCode>();

    public void registerRule(ValidateRule validatorRule, ErrorCode errorInfo) {
        this.validateRuleList.put(validatorRule, errorInfo);
    }

    public void validate(T value) throws ParameterException {
        for (Map.Entry<ValidateRule, ErrorCode> validateRuleStringEntry : validateRuleList.entrySet()) {
            ValidateRule validate = validateRuleStringEntry.getKey();
            ErrorCode errorInfo = validateRuleStringEntry.getValue();
            try {
                validate.validate(value);
            } catch (Exception ex) {
                throw new ParameterException(errorInfo);
            }

        }
    }
}


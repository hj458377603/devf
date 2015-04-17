package org.dream.web.service.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dream.bean.exception.ParameterException;
import org.dream.web.intf.validator.DataType;
import org.dream.web.intf.validator.Validator;
import org.dream.web.intf.validator.ValidatorService;
import org.springframework.stereotype.Service;

@Service("validatorService")
public class ValidatorServiceImpl<T> implements ValidatorService<T> {

    Map<DataType, Validator> validatorMap = new HashMap<DataType, Validator>();

    public void registerValidator(List<Validator> validatorList) {
        for (Validator validator : validatorList) {
            registerValidator(validator);
        }
    }

    public void registerValidator(Validator validator) {
        if (validatorMap.get(validator.getSupportedType()) != null) {
            throw new RuntimeException("alreay register " + validator.getSupportedType().toString());
        }
        validatorMap.put(validator.getSupportedType(), validator);
    }

    public void validate(DataType dataType, T value) throws ParameterException {
        Validator validator = validatorMap.get(dataType);
        validator.validate(value);
    }
}
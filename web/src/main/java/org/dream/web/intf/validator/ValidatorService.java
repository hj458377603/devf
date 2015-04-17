package org.dream.web.intf.validator;

import org.dream.bean.exception.ParameterException;

public interface ValidatorService<T> {
    void validate(DataType dataType, T value) throws ParameterException;
}

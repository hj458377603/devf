package org.dream.web.intf.validator;

import org.dream.bean.exception.ParameterException;

public interface Validator<T> {
    void validate(T value) throws ParameterException;

    DataType getSupportedType();
}

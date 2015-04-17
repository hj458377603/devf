package org.dream.web.intf.validator.rule;

public interface ValidateRule<T> {
    void validate(T value) throws Exception;
}

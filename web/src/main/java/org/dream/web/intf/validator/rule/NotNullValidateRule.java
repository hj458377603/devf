package org.dream.web.intf.validator.rule;


public class NotNullValidateRule implements ValidateRule {
    public void validate(Object o) throws Exception {
        if (o == null) {
            throw new Exception();
        }
    }
}

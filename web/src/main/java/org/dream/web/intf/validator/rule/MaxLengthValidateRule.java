package org.dream.web.intf.validator.rule;


public class MaxLengthValidateRule implements ValidateRule<String> {
    public int length;

    public MaxLengthValidateRule(int length) {
        this.length = length;
    }

    public void validate(String o) throws Exception {
        if (o == null || o.length() > length) {
            throw new Exception();
        }

    }
}

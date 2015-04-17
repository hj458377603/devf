package org.dream.web.intf.validator.rule;


/**
 * Created by 14120295 on 2015/1/9.
 */
public class LengthValidateRule implements ValidateRule<String> {
    public int length;

    public LengthValidateRule(int length) {
        this.length = length;
    }

    public void validate(String o) throws Exception {
        if (o == null || o.length() != length) {
            throw new Exception();
        }

    }
}

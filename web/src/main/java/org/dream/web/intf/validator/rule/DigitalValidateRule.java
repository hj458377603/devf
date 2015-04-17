package org.dream.web.intf.validator.rule;

public class DigitalValidateRule implements ValidateRule<String> {

    public DigitalValidateRule() {
    }

    public void validate(String o) throws Exception {
        Integer.valueOf(o);
    }
}

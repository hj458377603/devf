package org.dream.web.intf.validator.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxValidateRule implements ValidateRule<String> {
    public String regex;

    public RegxValidateRule(String regex) {
        this.regex = regex;
    }

    public void validate(String value) throws Exception {

        Matcher matcher = Pattern.compile(regex).matcher(value);
        if (!matcher.matches()) {
            throw new Exception();
        }

    }
}

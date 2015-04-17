package org.dream.web.intf.validator.rule;

public class UrlValidateRule implements ValidateRule<String> {
    public void validate(String url) throws Exception {
        if (url == null || url.length() < 5) {
            throw new Exception();
        }
    }
}

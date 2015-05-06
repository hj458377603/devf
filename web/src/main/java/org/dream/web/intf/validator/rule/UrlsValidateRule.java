package org.dream.web.intf.validator.rule;

public class UrlsValidateRule implements ValidateRule<String> {
    private int maxLength;

    private int maxNum;

    public UrlsValidateRule(int maxLength, int maxNum) {
        this.maxLength = maxLength;
        this.maxNum = maxNum;
    }

    public void validate(String str) throws Exception {
        if (str == null) {
            throw new Exception();
        }

        String[] imageUrls = str.split(",");
        if (imageUrls.length > maxNum) {
            throw new Exception();
        }

        for (String url : imageUrls) {
            if (url.length() > maxLength) {
                throw new Exception();
            }
        }
    }
}

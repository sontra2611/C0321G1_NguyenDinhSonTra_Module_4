package com.codegym.model.bean;

public class EmailBox {
    private String languages;
    private String pageSize;
    private Boolean spamFillter;
    private String signature;

    public EmailBox() {
    }

    public EmailBox(String languages, String pageSize, Boolean spamFillter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamFillter = spamFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamFillter() {
        return spamFillter;
    }

    public void setSpamFillter(Boolean spamFillter) {
        this.spamFillter = spamFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

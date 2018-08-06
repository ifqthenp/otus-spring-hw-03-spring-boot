package com.otus.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.locale")
public class AppLocaleSettings {

    private String i18n;
    private String file;
    private String ext;

    public String getI18n() {
        return i18n;
    }

    public void setI18n(final String i18n) {
        this.i18n = i18n;
    }

    public String getFile() {
        return file;
    }

    public void setFile(final String file) {
        this.file = file;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(final String ext) {
        this.ext = ext;
    }
}

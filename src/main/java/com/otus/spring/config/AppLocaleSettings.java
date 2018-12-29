package com.otus.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.locale")
public class AppLocaleSettings {

    private static final String PATH = "quiz/";
    private static final String EXT = ".csv";

    private String i18n;

    public String getI18n() {
        return PATH + i18n + EXT;
    }

    public void setI18n(final String i18n) {
        this.i18n = i18n;
    }

}

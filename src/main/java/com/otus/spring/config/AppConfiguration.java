package com.otus.spring.config;

import com.otus.spring.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@EnableConfigurationProperties({AppLocaleSettings.class})
public class AppConfiguration {

    private final AppLocaleSettings localeSettings;

    @Autowired
    public AppConfiguration(final AppLocaleSettings localeSettings) {
        this.localeSettings = localeSettings;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource =
            new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public String appLocale() {
        return this.localeSettings.getI18n();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            QuizService quizService = ctx.getBean(QuizService.class);
            quizService.run();
        };
    }

}

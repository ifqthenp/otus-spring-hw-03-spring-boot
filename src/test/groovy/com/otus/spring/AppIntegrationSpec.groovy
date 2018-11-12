package com.otus.spring

import com.otus.spring.config.AppConfiguration
import com.otus.spring.config.AppLocaleSettings
import com.otus.spring.service.impl.CsvResourceServiceImpl
import com.otus.spring.service.impl.QuizServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.core.env.Environment
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@ContextConfiguration(classes = [App, AppConfiguration, AppLocaleSettings, CsvResourceServiceImpl, QuizServiceImpl])
@TestPropertySource(properties = ["application.locale.i18n = en-GB"])
class AppIntegrationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "Application context loads"() {
        expect:
        context.containsBean("app")
        context.containsBean("quizServiceImpl")
        context.containsBean("appConfiguration")
        context.containsBean("appLocaleSettings")
        context.containsBean("messageSource")
        context.containsBean("csvResourceServiceImpl")
        context.containsBean("commandLineRunner")
    }
}

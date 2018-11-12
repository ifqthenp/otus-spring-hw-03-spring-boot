package com.otus.spring.service

import com.otus.domain.model.Quiz
import com.otus.spring.config.AppConfiguration
import com.otus.spring.config.AppLocaleSettings
import com.otus.spring.service.impl.CsvResourceServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [AppConfiguration, AppLocaleSettings, CsvResourceServiceImpl])
class CsvResourceServiceSpec extends Specification {

    @Autowired
    CsvResourceService csvResourceService

    void setup() {
        assert csvResourceService != null
    }

    def "getQuizList() returns list with quizzes"() {
        when:
        List<Quiz> quizList = csvResourceService.getQuizList()

        then:
        quizList.size() > 0
    }
}

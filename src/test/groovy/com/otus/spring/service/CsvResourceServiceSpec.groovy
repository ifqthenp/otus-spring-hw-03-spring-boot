package com.otus.spring.service

import com.otus.domain.model.Quiz
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.shell.Shell
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class CsvResourceServiceSpec extends Specification {

    @SpringBean
    Shell shell = Mock()

    @Subject
    @Autowired
    CsvResourceService csvResourceService

    void setup() {
        assert csvResourceService != null
    }

    def "getQuizList() returns list with quizzes"() {
        when:
        List<Quiz> quizList = csvResourceService.getQuizList()

        then:
        quizList != null
        quizList.size() > 0
    }
}

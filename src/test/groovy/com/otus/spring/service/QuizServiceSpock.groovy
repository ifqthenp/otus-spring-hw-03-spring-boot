package com.otus.spring.service

import spock.lang.Specification

class QuizServiceSpock extends Specification {

    QuizService quizService = Stub()

    def "Returns correct total score"() {
        given:
        quizService.getTotalScore() >> 3

        when:
        def totalScore = quizService.getTotalScore()

        then:
        totalScore == quizService.getTotalScore()
    }
}

package com.otus.domain.model

import spock.lang.Specification

class QuizSpec extends Specification {

    Quiz quiz

    void setup() {
        quiz = new Quiz()
    }

    def "getUserAnswers returns list of Integers"() {
        when:
        quiz.convertInputToScore(quiz, "2")

        then:
        quiz.userAnswers in List
    }
}

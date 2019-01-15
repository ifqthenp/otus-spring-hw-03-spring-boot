package com.otus.domain.model

import com.opencsv.bean.CsvToBeanBuilder
import spock.lang.Specification
import spock.lang.Subject

class QuizSpec extends Specification {

    @Subject
    Quiz quiz

    String testLocale

    void setupSpec() {
        System.properties.'test-locale' = 'en-GB'
    }

    void setup() {
        quiz = new Quiz()
        assert quiz != null
        testLocale = System.properties.'test-locale'
    }

    def "Newly created Quiz object has its attributes set to initial values"() {
        expect:
        with(quiz) {
            it.class in Quiz
            answer == null
            question == null
            options.isEmpty()
            options in ArrayList
            userAnswers.isEmpty()
            userAnswers in ArrayList
        }
    }

    def "Helper method getQuizList() returns list of quizzes from csv file"() {
        given:
        def list = getQuizList()

        expect:
        with(list) {
            it != null
            size() >= 5
            it.class in ArrayList
            it*.answer == ['4', '1', 'true', 'mc^2', '22/7']
        }
    }

    private List<Quiz> getQuizList() {
        getClass().getResource("/quiz/${testLocale}.csv").withReader { reader ->
            return new CsvToBeanBuilder<Quiz>(reader).withType(Quiz).build().parse()
        }
    }
}

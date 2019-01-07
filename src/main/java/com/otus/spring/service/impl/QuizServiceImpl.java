package com.otus.spring.service.impl;

import com.otus.domain.model.Quiz;
import com.otus.spring.service.CsvResourceService;
import com.otus.spring.service.QuizService;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

@Service
public class QuizServiceImpl implements QuizService {

    private Quiz quiz;
    private final Locale locale;
    private final List<Quiz> quizList;
    private final ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    public QuizServiceImpl(final CsvResourceService csvResourceService,
                           final ReloadableResourceBundleMessageSource messageSource,
                           final Environment env) {
        this.messageSource = messageSource;
        this.locale = Locale.forLanguageTag(Objects.requireNonNull(env.getProperty("application.locale.i18n")));
        this.quizList = csvResourceService.getQuizList();
    }

    @Override
    public void run() {
        this.quiz = new Quiz();
        try (Scanner in = new Scanner(new CloseShieldInputStream(System.in))) {
            System.out.print(messageSource.getMessage("user.name", null, locale));
            String userName = in.nextLine();
            System.out.println(messageSource.getMessage("user.introduction", new Object[]{userName}, locale));

            for (Quiz q : quizList) {
                System.out.println(messageSource.getMessage("user.question", new Object[]{q.getQuestion()}, locale));
                List<String> options = q.getOptions();

                int index = 1;
                for (String option : options) {
                    System.out.println(messageSource.getMessage("user.options", new Object[]{index, option}, locale));
                    index++;
                }
                System.out.print(messageSource.getMessage("user.answer", null, locale));
                int input = in.nextInt();
                quiz.convertInputToScore(q, options.get(input - 1));
            }

            final int userScore = getTotalScore();
            final int maxScore = quiz.getUserAnswers().size();
            System.out.println(messageSource.getMessage("user.totalScore", new Object[]{userScore, maxScore}, locale));
        }
    }

    @Override
    public int getTotalScore() {
        return quiz.getUserAnswers().stream().mapToInt(Integer::intValue).sum();
    }

}

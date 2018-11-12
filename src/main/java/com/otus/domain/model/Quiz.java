package com.otus.domain.model;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;

public class Quiz
{
    @CsvBindAndSplitByName(elementType = String.class, collectionType = ArrayList.class)
    private final List<String> options = new ArrayList<>();

    @CsvBindByName(column = "question")
    private String question;

    @CsvBindByName(column = "correct answer")
    private String answer;

    private List<Integer> userAnswers;

    public Quiz()
    {
        this.userAnswers = new ArrayList<>();
    }

    public List<Integer> getUserAnswers()
    {
        return this.userAnswers;
    }

    public List<String> getOptions()
    {
        return this.options;
    }

    public String getQuestion()
    {
        return this.question;
    }

    public String getAnswer()
    {
        return this.answer;
    }

    public void convertInputToScore(final Quiz quiz, final String input)
    {
        if (quiz.getAnswer().equals(input))
            this.userAnswers.add(1);
        else
            this.userAnswers.add(0);
    }

    @Override
    public String toString()
    {
        return "Quiz{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                '}';
    }
}

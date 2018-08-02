package com.otus.spring.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.otus.domain.model.Quiz;
import com.otus.spring.service.CsvResourceService;
import com.otus.spring.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvResourceServiceImpl implements CsvResourceService
{
    private final ResourceService resourceService;

    @Autowired
    public CsvResourceServiceImpl(final ResourceService resourceService)
    {
        this.resourceService = resourceService;
    }

    public List<Quiz> getQuizList()
    {
        List<Quiz> beans = null;
        try (InputStream is = resourceService.getCsvResource().getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            beans = new CsvToBeanBuilder<Quiz>(br).withType(Quiz.class).build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return beans;
    }
}

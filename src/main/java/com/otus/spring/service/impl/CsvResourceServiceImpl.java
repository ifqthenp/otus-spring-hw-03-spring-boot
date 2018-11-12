package com.otus.spring.service.impl;

import com.opencsv.bean.CsvToBeanBuilder;
import com.otus.domain.model.Quiz;
import com.otus.spring.config.AppLocaleSettings;
import com.otus.spring.service.CsvResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvResourceServiceImpl implements CsvResourceService {

    private final Resource resource;

    @Autowired
    public CsvResourceServiceImpl(final AppLocaleSettings locale, final ResourceLoader resLoader) {
        this.resource = resLoader.getResource(locale.getFile() + locale.getI18n() + locale.getExt());
    }

    public List<Quiz> getQuizList() {
        List<Quiz> beans = null;
        try (InputStream is = resource.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            beans = new CsvToBeanBuilder<Quiz>(br).withType(Quiz.class).build().parse();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return beans;
    }
}

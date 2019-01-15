package com.otus.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.Shell;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CsvResourceServiceTest {

    @MockBean
    Shell shell;

    @Autowired
    CsvResourceService csvResourceService;

    @Test
    void firstTest() {
        assertEquals(5, csvResourceService.getQuizList().size());
    }

}

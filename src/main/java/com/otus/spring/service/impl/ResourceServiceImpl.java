package com.otus.spring.service.impl;

import com.otus.spring.service.ResourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Value(value = "${resource.filename}${application.locale}${resource.ext}")
    private Resource csvResource;

    @Override
    public Resource getCsvResource() {
        return this.csvResource;
    }
}

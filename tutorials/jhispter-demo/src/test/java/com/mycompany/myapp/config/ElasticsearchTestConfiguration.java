package com.mycompany.myapp.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.elc.ReactiveElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.RefreshPolicy;

@Configuration
public class ElasticsearchTestConfiguration {

    @Autowired
    ReactiveElasticsearchTemplate template;

    @PostConstruct
    public void configureTemplate() {
        this.template.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
    }
}

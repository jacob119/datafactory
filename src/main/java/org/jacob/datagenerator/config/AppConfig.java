package org.jacob.datagenerator.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Bean
    public DataFactory getDataFactory() {
        return new DataFactory();
    }
}

package com.example.role_mining_frontend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies; // Import this
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // Configure the message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Create and configure the ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Register the JavaTimeModule to handle Java 8 Date and Time API types
        objectMapper.registerModule(new JavaTimeModule());

        // Disable writing dates as timestamps
        objectMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // Set the naming strategy to SNAKE_CASE
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // Set the custom ObjectMapper to the converter
        converter.setObjectMapper(objectMapper);

        // Replace the default message converters with the custom one
        restTemplate.getMessageConverters().add(0, converter);

        return restTemplate;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Register the JavaTimeModule to handle Java 8 Date and Time API types
        objectMapper.registerModule(new JavaTimeModule());

        // Disable writing dates as timestamps
        objectMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // Set the naming strategy to SNAKE_CASE
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        return objectMapper;
    }
}

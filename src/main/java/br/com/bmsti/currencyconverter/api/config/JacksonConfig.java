package br.com.bmsti.currencyconverter.api.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Class Jackson Configuration
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    public Jackson2ObjectMapperBuilderCustomizer objectMapper() {
        return builder -> builder.modules(new Jdk8Module(), new JavaTimeModule()).
                featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)
                .serializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
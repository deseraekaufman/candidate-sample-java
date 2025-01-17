package com.bravo.user.config;

import com.bravo.user.annotation.SwaggerController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
/*
Docket class - Docket is a builder which is intended to be the primary interface into the swagger-springmvc framework.
It provides sensible defaults and convenience methods for configuration.
 */
  @Bean
  public Docket docket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(SwaggerController.class))
        .paths(PathSelectors.any())
        .build()
        .directModelSubstitute(LocalDate.class, String.class)
        .directModelSubstitute(LocalDateTime.class, String.class)
        .directModelSubstitute(LocalTime.class, String.class);
  }
}

package com.example.thingsFlow.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("백엔드 다나와")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.thingsFlow.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API 테스트",
                "ThingsFlow Insert 기능 테스트 구현",
                "Version 1.0",
                "#",
                new Contact("Contact Me", "https://github.com/Backend-da-nawa/thingsFlow", "ehfql6363@naver.com"),
                null,
                "#",
                new ArrayList<>()
        );
    }
}

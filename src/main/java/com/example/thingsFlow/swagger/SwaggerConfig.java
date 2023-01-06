package com.example.thingsFlow.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {

    private static final String API_NAME = "Board API";
    private static final String NAME = "Dong-Yeol";
    private static final String URL = "https://www.notion.so/d3996619afd147a8a1afa0f1d1b1c283?v=db83a96204eb415c9b5095d5507cfd59";
    private static final String E_MAIL = "ehfql6363@naver.com";
    private static final String API_DESCRIPTION = "띵스플로우 API 명세서";

    private ApiInfo commonInfo() {
        return new ApiInfoBuilder()
                .title(API_NAME)
                .description(API_DESCRIPTION)
                .contact(new Contact(NAME, URL, E_MAIL))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("USER")
                .useDefaultResponseMessages(false)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.thingsFlow.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(commonInfo());
    }
}

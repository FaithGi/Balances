package com.balance.Balances.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/MY VODACOM APP_LITE")
public class SwaggerConfigurations
{

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MY VODACOM APP_LITE ")
                .description("REST API for MY VODACOM_APP_LITE")
                .termsOfServiceUrl("")
                .version("0.0.2-SNAPSHOT")
                .contact(new Contact("VODACOM", "", ""))
                .build();
    }

}
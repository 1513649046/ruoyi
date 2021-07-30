package com.ruoyi.web.core.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return  new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                .enable(true)
                .groupName("全部接口")
                .securitySchemes(security());

    }


    private List<SecurityScheme> security() {
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        return Collections.singletonList(apiKey);
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("资讯平台管理接口")
                .description("接口文档")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0")
                .build();
    }
}

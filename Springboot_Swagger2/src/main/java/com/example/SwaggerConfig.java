package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                // 路径使用any风格
                .paths(PathSelectors.any())
                .build();
//                // 如何保护我们的Api，有三种验证（ApiKey, BasicAuth, OAuth）
//                .securitySchemes(security())
//                // 接口文档的基本信息
//                .apiInfo(apiInfo());

        //第二种方法
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("yyblog项目 RESTful APIs")
                .description("yyblog项目api接口文档")
                .version("1.0")
                .build();
    }

    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;
    }

}
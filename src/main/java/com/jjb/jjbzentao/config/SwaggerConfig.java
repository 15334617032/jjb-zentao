package com.jjb.jjbzentao.config;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zxq
 * @date 2021/6/15
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String VERSION = "1.0.0";
    public static final String AUTHOR = "zxq";
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("禅道迭代模块")
                .select()
                //加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.jjb.jjbzentao.controller"))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(true);
    }

    @Bean
    public Docket createMonitorRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("权限模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fendo.mybatis.plus"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("API文档")
                //设置文档的描述
                .description("禅道项目API文档")
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                //设置文档的版本信息
                .version(VERSION)
                //作者信息
                .contact(new Contact(AUTHOR, "http://blog.csdn.net/u011781521", "49315866@qq.com"))
                //设置文档的License信息
                .termsOfServiceUrl("http://blog.csdn.net/u011781521?viewmode=contents")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}

package com.jjb.jjbzentao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.jjb.jjbzentao.dao")
public class JjbZentaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JjbZentaoApplication.class, args);
    }

}

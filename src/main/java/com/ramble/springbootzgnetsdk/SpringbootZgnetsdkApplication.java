package com.ramble.springbootzgnetsdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableOpenApi
@EnableWebMvc
@SpringBootApplication
public class SpringbootZgnetsdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZgnetsdkApplication.class, args);
    }

}

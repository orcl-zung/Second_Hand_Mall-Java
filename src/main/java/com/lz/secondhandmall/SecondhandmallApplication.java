package com.lz.secondhandmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages = {"com.definesys.mpaas","com.lz.secondhandmall"})
@SpringBootApplication(exclude = {ValidationAutoConfiguration.class, FreeMarkerAutoConfiguration.class})
@EnableTransactionManagement
public class SecondhandmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondhandmallApplication.class, args);
    }

}

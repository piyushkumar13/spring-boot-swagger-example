package com.example.swaggerannotationconfigexample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My Swagger Apis", description = "This project contains set of sample apis depicting swagger usage", version = "1.0"))
@SecurityScheme(name="sampleappsecurity", description = "Authn & Authz for the application",scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
//@SecurityScheme(name="Api-key", description = "Api Key", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, paramName="API-KEY")
public class SwaggerAnnotationConfigExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerAnnotationConfigExampleApplication.class, args);
    }

}

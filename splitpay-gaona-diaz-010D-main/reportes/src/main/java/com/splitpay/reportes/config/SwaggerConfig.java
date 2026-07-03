package com.splitpay.reportes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI splitPayOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservicio de Reportes")
                        .version("1.0")
                        .description("Documentación de la API del microservicio de Reportes"));
    }
}
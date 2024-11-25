package org.kinaxis.platform.u202215313.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI platformOpenApi() {

        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("HIGN. API")
                        .description("API for HIGN. project")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("HIGN. Wiki Documentation")
                        .url("(https://hign.org/"));




        return openApi;
    }
}
package com.ltp.contacts.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenAiConfig {
    @Bean
    public OpenAPI getOpenAPI(){
        return new OpenAPI();
    }

//    @Bean
//    public GroupedOpenApi contactApi() {
//        return GroupedOpenApi.builder()
//                .group("Contact Controller")
//                .pathsToMatch("/v1/contacts/**")
//                .build();
//    }
}




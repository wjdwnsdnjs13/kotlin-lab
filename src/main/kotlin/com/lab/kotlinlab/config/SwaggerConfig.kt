package com.lab.kotlinlab.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(swaggerInfo())
    }

    private fun swaggerInfo(): Info {
        return Info()
            .version("v0.0.1")
            .title("kotlin-lab API 문서")
            .description("kotlin-lab API 문서입니다.")
    }
}

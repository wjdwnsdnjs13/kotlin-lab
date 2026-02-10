package com.lab.labkotlin.config

import com.lab.labkotlin.application.MailgunHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class MailgunHttpClientConfig(
    @Value("\${mailgun.api-base-url}")
    private val mailgunApiBaseUrl: String,
) {
    @Bean
    fun mailgunHttpClient(): MailgunHttpClient {
        val webClient: WebClient =
            WebClient.builder()
                .baseUrl(mailgunApiBaseUrl)
                .build()

        val factory: HttpServiceProxyFactory =
            HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient))
                .build()

        return factory.createClient(MailgunHttpClient::class.java)
    }
}

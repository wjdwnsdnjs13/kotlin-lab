package com.lab.labkotlin.application

import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange("https://api.mailgun.net/v3")
interface MailgunHttpClient {
    @PostExchange("/{domain}/messages")
    suspend fun send(
        @PathVariable domain: String,
        @HttpHeader("Authorization") auth: String,
        @RequestBody body: MultiValueMap<String, String>,
    )
}

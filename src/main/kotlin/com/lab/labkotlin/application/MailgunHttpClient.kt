package com.lab.labkotlin.application

import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PostExchange

@HttpExchange
interface MailgunHttpClient {
    @PostExchange("/{domain}/messages")
    suspend fun send(
        @PathVariable domain: String,
        @RequestHeader("Authorization") auth: String,
        @RequestBody body: MultiValueMap<String, String>,
    )
}

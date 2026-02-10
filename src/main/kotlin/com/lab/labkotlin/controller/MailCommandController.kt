package com.lab.labkotlin.controller

import com.lab.labkotlin.application.email.EmailRequest
import com.lab.labkotlin.controller.req.SendEmailRequest
import com.lab.labkotlin.service.MailCommandService
import com.lab.labkotlin.service.outbound.EmailComparisonResult
import com.lab.labkotlin.service.outbound.EmailSendResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/emails")
@RestController
class MailCommandController(
    private val mailCommandService: MailCommandService,
) {
    @PostMapping("/smtp")
    suspend fun sendViaSmtp(
        @RequestBody request: SendEmailRequest,
    ): EmailSendResult = mailCommandService.sendViaSmtp(request.toEmailRequest())

    @PostMapping("/mailgun-sdk")
    suspend fun sendViaMailgunSdk(
        @RequestBody request: SendEmailRequest,
    ): EmailSendResult = mailCommandService.sendViaMailgunSdk(request.toEmailRequest())

    @PostMapping("/http-exchange")
    suspend fun sendViaHttpExchange(
        @RequestBody request: SendEmailRequest,
    ): EmailSendResult = mailCommandService.sendViaHttpExchange(request.toEmailRequest())

    @PostMapping("/compare")
    suspend fun compareAllMethods(
        @RequestBody request: SendEmailRequest,
    ): EmailComparisonResult = mailCommandService.compareAllMethods(request.toEmailRequest())

    private fun SendEmailRequest.toEmailRequest() =
        EmailRequest(
            to = this.to,
            title = this.title,
            body = this.body,
        )
}

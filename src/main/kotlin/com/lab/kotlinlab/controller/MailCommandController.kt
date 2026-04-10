package com.lab.kotlinlab.controller

import com.lab.kotlinlab.application.email.EmailSendMethod
import com.lab.kotlinlab.controller.req.PublishEmailRequest
import com.lab.kotlinlab.controller.req.SendEmailRequest
import com.lab.kotlinlab.service.MailCommandService
import com.lab.kotlinlab.service.outbound.EmailComparisonResult
import com.lab.kotlinlab.service.outbound.EmailSendResult
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
    ): EmailSendResult = mailCommandService.sendViaSmtp(request.toEmailRequest(EmailSendMethod.SMTP))

    @PostMapping("/mailgun-sdk")
    suspend fun sendViaMailgunSdk(
        @RequestBody sendEmailRequest: SendEmailRequest,
    ): EmailSendResult =
        mailCommandService.sendViaMailgunSdk(
            sendEmailRequest.toEmailRequest(EmailSendMethod.MAILGUN_SDK),
        )

    @PostMapping("/http-exchange")
    suspend fun sendViaHttpExchange(
        @RequestBody sendEmailRequest: SendEmailRequest,
    ): EmailSendResult =
        mailCommandService.sendViaHttpExchange(
            sendEmailRequest.toEmailRequest(EmailSendMethod.HTTP_EXCHANGE),
        )

    @PostMapping("/compare")
    suspend fun compareAllMethods(
        @RequestBody sendEmailRequest: SendEmailRequest,
    ): EmailComparisonResult =
        mailCommandService.compareAllMethods(
            sendEmailRequest.toEmailRequest(EmailSendMethod.COMPARE),
        )

    @PostMapping("/publish")
    suspend fun publishEmail(
        @RequestBody publishEmailRequest: PublishEmailRequest,
    ) {
        mailCommandService.publishEmail(publishEmailRequest.toEmailRequest())
    }
}

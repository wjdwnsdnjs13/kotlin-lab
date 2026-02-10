package com.lab.labkotlin.service

import com.lab.labkotlin.application.HttpExchangeEmailSender
import com.lab.labkotlin.application.MailgunSdkEmailSender
import com.lab.labkotlin.application.SmtpEmailSender
import com.lab.labkotlin.application.email.EmailRequest
import com.lab.labkotlin.service.outbound.EmailComparisonResult
import com.lab.labkotlin.service.outbound.EmailSendResult
import kotlinx.coroutines.coroutineScope
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.system.measureTimeMillis

@Service
class MailCommandService(
    private val smtpEmailSender: SmtpEmailSender,
    private val mailgunSdkEmailSender: MailgunSdkEmailSender,
    private val httpExchangeEmailSender: HttpExchangeEmailSender,
) {
    private val logger = LoggerFactory.getLogger(MailCommandService::class.java)

    suspend fun sendViaSmtp(request: EmailRequest): EmailSendResult {
        val duration =
            measureTimeMillis {
                smtpEmailSender.send(request)
            }
        logger.info("SMTP 이메일 전송 완료: ${duration}ms")
        return EmailSendResult("SMTP", duration, true)
    }

    suspend fun sendViaMailgunSdk(request: EmailRequest): EmailSendResult {
        val duration =
            measureTimeMillis {
                mailgunSdkEmailSender.send(request)
            }
        logger.info("Mailgun SDK 이메일 전송 완료: ${duration}ms")
        return EmailSendResult("Mailgun SDK", duration, true)
    }

    suspend fun sendViaHttpExchange(request: EmailRequest): EmailSendResult {
        val duration =
            measureTimeMillis {
                httpExchangeEmailSender.send(request)
            }
        logger.info("HttpExchange 이메일 전송 완료: ${duration}ms")
        return EmailSendResult("HttpExchange", duration, true)
    }

    suspend fun compareAllMethods(request: EmailRequest): EmailComparisonResult =
        coroutineScope {
            logger.info("세 가지 방법으로 이메일 전송 비교 시작")

            // 순차적으로 실행해서 각각의 시간 측정
            val smtpResult =
                runCatching {
                    sendViaSmtp(request)
                }.getOrElse { e ->
                    logger.error("SMTP 전송 실패", e)
                    EmailSendResult("SMTP", 0, false, e.message)
                }

            val mailgunSdkResult =
                runCatching {
                    sendViaMailgunSdk(request)
                }.getOrElse { e ->
                    logger.error("Mailgun SDK 전송 실패", e)
                    EmailSendResult("Mailgun SDK", 0, false, e.message)
                }

            val httpExchangeResult =
                runCatching {
                    sendViaHttpExchange(request)
                }.getOrElse { e ->
                    logger.error("HttpExchange 전송 실패", e)
                    EmailSendResult("HttpExchange", 0, false, e.message)
                }

            val results = listOf(smtpResult, mailgunSdkResult, httpExchangeResult)
            val fastest = results.filter { it.success }.minByOrNull { it.durationMs }

            logger.info("전송 비교 완료 - 가장 빠른 방법: ${fastest?.method}")

            EmailComparisonResult(
                results = results,
                fastestMethod = fastest?.method,
            )
        }
}

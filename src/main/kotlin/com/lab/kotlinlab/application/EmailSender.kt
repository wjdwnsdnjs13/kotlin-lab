package com.lab.labkotlin.application

import com.lab.labkotlin.application.email.EmailRequest

interface EmailSender {
    suspend fun send(request: EmailRequest)
}

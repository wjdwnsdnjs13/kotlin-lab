package com.lab.kotlinlab.application

import com.lab.kotlinlab.application.email.EmailRequest

interface EmailSender {
    suspend fun send(request: EmailRequest)
}

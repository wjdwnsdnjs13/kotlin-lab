package com.lab.labkotlin.application.email

enum class EmailSendMethod(val value: String) {
    SMTP("SMTP"),
    MAILGUN_SDK("MAILGUN_SDK"),
    HTTP_EXCHANGE("HTTP_EXCHANGE"),
}

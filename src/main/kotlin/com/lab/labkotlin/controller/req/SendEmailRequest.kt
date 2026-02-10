package com.lab.labkotlin.controller.req

data class SendEmailRequest(
    val to: String,
    val title: String,
    val body: String,
)

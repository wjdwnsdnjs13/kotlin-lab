package com.lab.labkotlin.application.email

data class EmailRequest(
    val to: String,
    val from: String,
    val subject: String,
    val content: String,
    val body: String,
)

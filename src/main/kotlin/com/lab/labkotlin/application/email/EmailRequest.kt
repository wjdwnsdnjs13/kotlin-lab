package com.lab.labkotlin.application.email

data class EmailRequest(
    val to: String,
    val title: String,
    val body: String,
)

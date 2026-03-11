package com.lab.kotlinlab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class KotlinLabApplication

fun main(args: Array<String>) {
    runApplication<KotlinLabApplication>(*args)
}

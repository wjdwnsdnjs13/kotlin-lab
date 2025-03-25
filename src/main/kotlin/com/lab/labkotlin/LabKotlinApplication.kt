package com.lab.labkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class LabKotlinApplication

fun main(args: Array<String>) {
    runApplication<LabKotlinApplication>(*args)
}

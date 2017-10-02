package com.dstoklosa.webfluxapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebfluxAppApplication

fun main(args: Array<String>) {
    SpringApplication.run(WebfluxAppApplication::class.java, *args)
}

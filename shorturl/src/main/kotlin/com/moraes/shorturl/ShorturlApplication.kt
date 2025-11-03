package com.moraes.shorturl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@SpringBootApplication
class ShorturlApplication

fun main(args: Array<String>) {
	runApplication<ShorturlApplication>(*args)
}



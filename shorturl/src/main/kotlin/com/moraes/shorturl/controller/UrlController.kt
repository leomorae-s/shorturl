package com.moraes.shorturl.controller

import com.moraes.shorturl.service.UrlService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController("/")
class UrlController(private val urlService: UrlService) {


    @PostMapping("/shortener")
    fun saveUrl(@RequestBody url: String): Unit = urlService.shortener(url)

    @GetMapping("/redirect/{id}")
    fun redirect(@PathVariable id: Long): ResponseEntity<Any> {

        val redirectUrl:String = urlService.redirectUrl(id)

        val uri: URI = URI.create(redirectUrl)
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(uri)
            .build()
    }
}
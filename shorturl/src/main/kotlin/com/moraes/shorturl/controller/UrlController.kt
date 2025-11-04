package com.moraes.shorturl.controller

import com.moraes.shorturl.dto.UrlShortenerDTO
import com.moraes.shorturl.model.UrlModel
import com.moraes.shorturl.service.UrlService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController("/")
class UrlController(private val urlService: UrlService) {


    @PostMapping("/shortener")
    fun saveUrl(@RequestBody url: UrlShortenerDTO): Unit = urlService.shortener(url.originalUrl)

    @GetMapping("/redirect/{id}")
    fun redirect(@PathVariable id: Long): ResponseEntity<Any> {

        val redirectUrl: UrlModel = urlService.redirectUrl(id)

        val uri: URI = URI.create(redirectUrl.originalUrl)
        return ResponseEntity
            .status(HttpStatus.FOUND)
            .location(uri)
            .build()
    }
}
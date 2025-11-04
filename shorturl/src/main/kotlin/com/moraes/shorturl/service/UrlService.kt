package com.moraes.shorturl.service

import com.moraes.shorturl.model.UrlModel
import com.moraes.shorturl.repository.UrlRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UrlService(private val urlRepository: UrlRepository) {

    fun shortener(url: String) {

        val incomingUrl = UrlModel(originalUrl = url)

        urlRepository.save<UrlModel>(incomingUrl)
    }


    fun redirectUrl(id: Long): UrlModel {

        val model: UrlModel? = urlRepository.findByIdOrNull(id)



        return model ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Url de id $id não encontrada")
    }
}
package com.moraes.shorturl.service

import com.moraes.shorturl.model.UrlModel
import com.moraes.shorturl.repository.UrlRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UrlService(private val urlRepository: UrlRepository) {

    public fun shortener(url: String) {

        val incomingUrl = UrlModel(originalUrl = url)

        urlRepository.save<UrlModel>(incomingUrl)
    }


    public fun redirectUrl(id: Long): String {

        val model: Optional<UrlModel> = urlRepository.findById(id)

        return model.get().originalUrl

    }
}
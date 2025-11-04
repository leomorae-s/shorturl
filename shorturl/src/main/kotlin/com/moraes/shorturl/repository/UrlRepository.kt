package com.moraes.shorturl.repository

import com.moraes.shorturl.model.UrlModel
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository: JpaRepository<UrlModel, Long> {
}
package com.example.service

import com.example.di.kodein
import com.example.dto.ArticleDTO
import com.example.repository.ArticleRepo
import io.ktor.http.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ArticleService {
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val articleRepo by kodein.instance<ArticleRepo>()

    suspend fun saveArticle(articleData: ArticleDTO): HttpStatusCode {
        log.info("saveArticle -> articleData == $articleData")
        return articleRepo.saveArticle(articleData)
    }

    suspend fun getArticles(authorId: Int?): List<ArticleDTO> {
        return if (authorId == null) articleRepo.getArticles() else articleRepo.articlesRelatedToAuthor(authorId)
    }

//    suspend fun articlesRelatedToAuthor(authorId:Int): List<ArticleDTO> {
//        return articleRepo.articlesRelatedToAuthor(authorId)
//    }
}

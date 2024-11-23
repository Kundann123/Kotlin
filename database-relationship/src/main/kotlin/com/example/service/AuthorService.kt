package com.example.service

import com.example.di.kodein
import com.example.dto.AuthorDTO
import com.example.entities.ArticleEntity
import com.example.entities.AuthorEntity
import com.example.repository.AuthorRepo
import io.ktor.http.*
import org.kodein.di.instance
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AuthorService {
    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val authorRepo by kodein.instance<AuthorRepo>()

    suspend fun saveAuthor(authorData: AuthorDTO): HttpStatusCode {
        log.info("saveArticle -> authorData == $authorData")
        return authorRepo.saveAuthor(authorData)
    }

    suspend fun getAuthors(id:Int?): List<AuthorDTO> {
        return if (id == null) authorRepo.getAuthors() else authorRepo.getAuthor(id)
    }

    suspend fun authorWithArticles(authorId:Int): Pair<AuthorEntity, List<ArticleEntity>>? {
        return authorRepo.authorWithArticles(authorId)
    }
}
package com.example.repository

import com.example.config.DBConfig
import com.example.dto.ArticleDTO
import com.example.entities.ArticleEntities
import io.ktor.http.*
import org.ktorm.dsl.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ArticleRepo {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    suspend fun saveArticle(articleData: ArticleDTO): HttpStatusCode {
       DBConfig.dbQuery {
           DBConfig.getDatabase().insert(ArticleEntities){
               set(it.articleId, articleData.articleId)
               set(it.title, articleData.title)
               set(it.authorRefId, articleData.authorRefId)
           }
       }
        return HttpStatusCode.Created
    }

    suspend fun getArticles(): List<ArticleDTO> {
        val res =  DBConfig.dbQuery {
            DBConfig.getDatabase().from(ArticleEntities).select().map { ArticleEntities.createEntity(it) }.map {
                ArticleDTO(
                    it.articleId,
                    it.title,
                    it.author.authorId
                )
            }
        }
        return res
    }

    suspend fun articlesRelatedToAuthor(authorId: Int): List<ArticleDTO> {
        val articlesList = DBConfig.dbQuery {
            DBConfig.getDatabase().from(ArticleEntities).select().where { ArticleEntities.authorRefId eq authorId }
                .map {
                    ArticleEntities.createEntity(it)
                }.map {
                ArticleDTO(
                    it.articleId,
                    it.title,
                    it.author.authorId
                )
            }
        }
        return articlesList
    }

}
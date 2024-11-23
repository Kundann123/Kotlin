package com.example.repository

import com.example.config.DBConfig
import com.example.dto.AuthorDTO
import com.example.entities.ArticleEntities
import com.example.entities.ArticleEntity
import com.example.entities.AuthorEntities
import com.example.entities.AuthorEntity
import io.ktor.http.*
import org.ktorm.dsl.*
import org.ktorm.entity.filter
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class AuthorRepo {

    suspend fun saveAuthor(authorData: AuthorDTO): HttpStatusCode {
        DBConfig.dbQuery {
            DBConfig.getDatabase().insert(AuthorEntities) {
                set(it.authorId, authorData.authorId)
                set(it.authorName, authorData.authorName)
            }
        }
        return HttpStatusCode.Created
    }

    suspend fun getAuthors(): List<AuthorDTO> {
        val authorsList = DBConfig.dbQuery {
            DBConfig.getDatabase().from(AuthorEntities).select().map { AuthorEntities.createEntity(it) }.map {
                AuthorDTO(
                    it.authorId,
                    it.authorName
                )
            }
        }
        return authorsList
    }

    suspend fun getAuthor(id: Int): List<AuthorDTO> {
        val author = DBConfig.dbQuery {
            DBConfig.getDatabase().from(AuthorEntities).select().where { AuthorEntities.authorId eq id }.map {
                AuthorEntities.createEntity(it)
            }.map {
                AuthorDTO(
                    it.authorId, it.authorName
                )
            }
        }
        return author
    }

    suspend fun authorWithArticles(authorId: Int): Pair<AuthorEntity, List<ArticleEntity>>? {
        val authorWithArticles = DBConfig.dbQuery {
            DBConfig.getDatabase().sequenceOf(AuthorEntities).find { it.authorId eq authorId }?.let { author ->
                val articles = DBConfig.getDatabase().sequenceOf(ArticleEntities).filter {
                    it.authorRefId eq authorId
                }.toList()
                author to articles
            }
        }
        return authorWithArticles
    }

}
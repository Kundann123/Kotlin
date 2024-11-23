package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface ArticleEntity: Entity<ArticleEntity> {
    val articleId: Int
    val title: String
    val author: AuthorEntity
}

object ArticleEntities: Table<ArticleEntity>("article_data") {
    val articleId = int("article_id").primaryKey().bindTo { it.articleId }
    val title = varchar("title").bindTo { it.title }
    val authorRefId = int("author_ref_id").references(AuthorEntities){it.author}
}

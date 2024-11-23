package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface AuthorEntity: Entity<AuthorEntity> {
    val authorId: Int
    val authorName: String
    val articles: List<ArticleEntity>
}

object AuthorEntities: Table<AuthorEntity>("author_data"){
    val authorId = int("author_id").primaryKey().bindTo { it.authorId }
    val authorName = varchar("author_name").bindTo { it.authorName }
}

package com.example.di

import com.example.repository.ArticleRepo
import com.example.repository.AuthorRepo
import com.example.service.ArticleService
import com.example.service.AuthorService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val kodein = DI{
    bind<AuthorRepo>() with singleton { AuthorRepo() }
    bind<AuthorService>() with singleton { AuthorService() }
    bind<ArticleRepo>() with singleton { ArticleRepo() }
    bind<ArticleService>() with singleton { ArticleService() }
}
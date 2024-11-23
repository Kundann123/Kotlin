package com.example.di

import com.example.repo.UserRepository
import com.example.service.UserService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val kodein= DI{
    bind<UserRepository>() with singleton { UserRepository() }
    bind<UserService>() with singleton { UserService() }
}
package com.example.service

import com.example.dbconfig.Configuration
import com.example.dbconfig.MongoDBConfigFactory
import com.example.dto.UserDTO
import io.ktor.server.config.ApplicationConfig
import io.ktor.server.testing.createTestEnvironment
import io.mockk.MockKAnnotations
import io.mockk.mockkObject
import kotlinx.coroutines.runBlocking
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals

class UserServiceTest {

    private lateinit var userService: UserService

    @Before
    fun setUp() {
        createTestEnvironment {
            config = ApplicationConfig(
                "application.conf"
            )
            Configuration.initConfig(this.build { })
        }
        MockKAnnotations.init(this)
        mockkObject(Configuration)
        mockkObject(MongoDBConfigFactory)
        userService = UserService()
    }

    @Test
    fun getUserDetails() {
        val body = "6"
        val expected = "9874567890"
        runBlocking {
            val result = userService.getUser(body) as UserDTO
            assertEquals(expected, result.mobb)
        }
    }

}




package com.example.service

import com.example.di.kodein
import com.example.dto.BodyException
import com.example.dto.UserDTO
import com.example.dto.validateUser
import com.example.exception.UserBadRequestException
import com.example.repo.UserRepository
import io.konform.validation.Invalid
import org.kodein.di.instance

class UserService {
    private val userRepository by kodein.instance<UserRepository>()

    suspend fun addUser(body: UserDTO): Any {
        val validData = mutableListOf<BodyException>()
        val validationResult = validateUser.validate(body)
        if (validationResult is Invalid) {
            validationResult.errors.map {
                validData.add(
                    BodyException(
                        it.dataPath.substring(1),
                        it.message
                    )
                )
            }
            throw UserBadRequestException(validData.toString())
        }
        return userRepository.addUser(body)
    }

    suspend fun getUser(id: String): Any? {
        return userRepository.getUser(id)
    }

    suspend fun deleteUser(id: String?): Any {
        return userRepository.deleteUser(id)
    }

    suspend fun updateUser(user: UserDTO): Any {
        return userRepository.updateUser(user)
    }

    suspend fun updateUserById(user: UserDTO): Any {
        return userRepository.updateUser(user)
    }
}
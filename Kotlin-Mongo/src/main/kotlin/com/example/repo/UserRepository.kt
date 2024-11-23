package com.example.repo

import com.example.dbconfig.MongoDBConfigFactory
import com.example.dto.UserDTO
import io.ktor.http.HttpStatusCode
import org.litote.kmongo.eq
import org.litote.kmongo.setTo

class UserRepository {
    private val userCollection = MongoDBConfigFactory.getDatabase().getCollection<UserDTO>()

    suspend fun addUser(body: UserDTO): Any {
        userCollection.insertOne(body)
        return HttpStatusCode.OK
    }

    suspend fun getUser(id: String): Any? {
        return userCollection.findOne(UserDTO::userId eq id)
    }

    suspend fun deleteUser(id: String?): Any {
        //val filter=Filters.eq("userId",id)
        userCollection.deleteOne(UserDTO::userId eq id)
        return HttpStatusCode.OK
    }

    suspend fun updateUser(body: UserDTO): Any {
        userCollection.updateMany(
            UserDTO::userId eq body.userId,
            UserDTO::name setTo body.name,
            UserDTO::email setTo body.email,
            UserDTO::pass setTo body.pass,
            UserDTO::mobb setTo body.mobb
        )
        return HttpStatusCode.OK
    }

    suspend fun updateUserById(body: UserDTO): Any {
        userCollection.updateOne("{\"userId\":\"${body.userId}\"}", body)
        return HttpStatusCode.OK
    }
}
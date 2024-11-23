package com.example.repository

import com.example.dbconfig.database
import com.example.entities.Masters
import io.ktor.http.*
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq

class DeleteRepository {
    fun deleteMasterDate(id: String): Any {
        val deletion = database.delete(Masters) {
            it.id eq id
        }
        return if (deletion==1) HttpStatusCode.OK
        else HttpStatusCode.NotModified

    }
}
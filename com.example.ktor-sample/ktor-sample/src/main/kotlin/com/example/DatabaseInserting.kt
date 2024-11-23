package com.example

import com.example.dbconfig.database
import com.example.entities.Master
import com.example.entities.Masters
import com.example.model.MasterDTO
import io.ktor.http.*
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insert
import org.ktorm.dsl.update
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

class DatabaseInserting {
    fun insertMasterDate(body: MasterDTO): Int {
        return database.insert(Masters) {
            set(it.id, body.id)
            set(it.type, body.type)
            set(it.name, body.name)
            set(it.shortName, body.shortName)
            set(it.activeFlag, body.activeFlag)
            set(it.createdByUser, body.createdByUser)
            set(it.createdByDate, body.createdByDate)
            set(it.modifiedByUser, body.modifiedByUser)
            set(it.modifiedByDate, body.modifiedByDate)
        }.also { println(it) }
    }

    fun updateMasterDate(body: MasterDTO) {
        database.update(Masters) {
            set(it.name, body.name)
            set(it.shortName, body.shortName)
            set(it.createdByUser, body.createdByUser)
            where {
                it.id eq body.id
            }
        }
    }


}
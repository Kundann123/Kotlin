package com.example.repository

import com.example.dbconfig.database
import com.example.entities.Masters
import com.example.model.MasterDTO
import org.ktorm.dsl.insert

class MasterRepository {
    fun saveMasterDetails(body: MasterDTO): Int {
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
}
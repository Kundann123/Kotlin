package com.example.entities

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface Master : Entity<Master> {
    val id: String
    val type: String
    val name: String
    val shortName: String
    val activeFlag: String
    val createdByUser: String
    val createdByDate: String
    val modifiedByUser: String
    val modifiedByDate: String
}

object Masters : Table<Master>("master_date") {
    val id = varchar("id").primaryKey().bindTo { it.id }
    val type = varchar("type").bindTo { it.type }
    val name = varchar("name").bindTo { it.name }
    val shortName = varchar("short_name").bindTo { it.shortName }
    val activeFlag = varchar("active_flag").bindTo { it.activeFlag }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate = varchar("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser = varchar("modified_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate = varchar("modified_by_date").bindTo { it.modifiedByDate }

}
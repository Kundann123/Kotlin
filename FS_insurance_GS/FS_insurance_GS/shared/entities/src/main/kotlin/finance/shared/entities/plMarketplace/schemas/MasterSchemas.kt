package finance.shared.entities.plMarketplace.schemas

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime

object PlLenderMasterSchema : IdTable<String>("lending_pl.lender_master") {
    var lenderId = varchar("lender_id", 255).uniqueIndex()
    var entityName = varchar("entity_name", 255)
    var lenderCode = varchar("lender_code", 255)
    var lenderType = varchar("lender_type", 255)
    var status = varchar("status", 255)
    var lenderIconUrlRectangle = varchar("lender_icon_url_rectangle", 255)
    var lenderIconUrlSquare = varchar("lender_icon_url_square", 255)
    var createdOn = datetime("created_on")
    var createdBy = varchar("created_by",255)
    var updatedOn = datetime("updated_on").nullable()
    var updatedBy = varchar("updated_by", 255).nullable()
    override val id: Column<EntityID<String>> = lenderId.entityId()
}

object CompanyInfoMaster : IdTable<Long>("lending_pl.company_info"){
    var companyCode = long("company_code").uniqueIndex()
    var companyCategory = varchar("company_category",255)
    var companyName = varchar("company_name",255)
    override val id: Column<EntityID<Long>> = companyCode.entityId()
}

object PinDetailsMasterSchema : IdTable<Int>("lending_pl.pin_details"){
    var pin = integer("pins").uniqueIndex()
    var tcapServiceable = bool("tcap_serviceable")
    var iiflServiceable = bool("iifl_serviceable")
    var lastUpdatedTimestamp = datetime("lastupdatedtimestamp")
    override val id: Column<EntityID<Int>> = pin.entityId()
}
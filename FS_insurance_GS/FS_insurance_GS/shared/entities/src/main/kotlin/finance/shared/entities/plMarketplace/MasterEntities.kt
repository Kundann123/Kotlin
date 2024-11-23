package finance.shared.entities.plMarketplace

import finance.shared.entities.plMarketplace.schemas.CompanyInfoMaster
import finance.shared.entities.plMarketplace.schemas.PinDetailsMasterSchema
import finance.shared.entities.plMarketplace.schemas.PlLenderMasterSchema
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class PlLenderMasterEntity(lenderId: EntityID<String>) : Entity<String>(lenderId) {
    companion object : EntityClass<String, PlLenderMasterEntity>(PlLenderMasterSchema)

    var lenderId by PlLenderMasterSchema.lenderId
    var entityName by PlLenderMasterSchema.entityName
    var lenderType by PlLenderMasterSchema.lenderType
    var lenderCode by PlLenderMasterSchema.lenderCode
    var status by PlLenderMasterSchema.status
    var lenderIconUrlRectangle by PlLenderMasterSchema.lenderIconUrlRectangle
    var lenderIconUrlSquare by PlLenderMasterSchema.lenderIconUrlSquare
    var createdOn by PlLenderMasterSchema.createdOn
    var updatedOn by PlLenderMasterSchema.updatedOn
    var createdBy by PlLenderMasterSchema.createdBy
    var updatedBy by PlLenderMasterSchema.updatedBy
}

class CompanyInfoEntities (companyCode : EntityID<Long>) : Entity<Long>(companyCode){
    companion object : EntityClass<Long,CompanyInfoEntities>(CompanyInfoMaster)
    var companyCode by CompanyInfoMaster.companyCode
    var companyCategory by CompanyInfoMaster.companyCategory
    var companyName by CompanyInfoMaster.companyName
}

class PinDetailsEntity(pin: EntityID<Int>): Entity<Int>(pin) {

    companion object : EntityClass<Int, PinDetailsEntity>(PinDetailsMasterSchema)

    var pin by PinDetailsMasterSchema.pin
    var tcapServiceable by PinDetailsMasterSchema.tcapServiceable
    var iiflServiceable by PinDetailsMasterSchema.iiflServiceable
    var lastUpdatedTimestamp by PinDetailsMasterSchema.lastUpdatedTimestamp
}

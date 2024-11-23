import com.tdl.guaranteedsavings.entities.InsurancePolicies
import com.tdl.guaranteedsavings.entities.InsurancePolicy
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface InsurerMaster: Entity<InsurerMaster> {

    val insurerId: String
    val insurerName: String
    val insurerDesc: String
    val agentCode: String
    val activeFlag: String
    val createdByUser: String
    val createdByDate: String
    val modifiedByUser: String
    val modifiedByDate: String
    val insurancePolicy: InsurancePolicy
}

object InsurerMasters : Table<InsurerMaster>("insurer_master")
{
    val insurerId = varchar("insurer_id").references(InsurancePolicies) {it.insurancePolicy}.primaryKey()
    val insurerName = varchar("insurer_name").bindTo { it.insurerName }
    val insurerDesc = varchar("insurer_desc").bindTo { it.insurerDesc }
    val agentCode = varchar("agentCode").bindTo { it.agentCode }
    val activeFlag = varchar("actve_flag").bindTo { it.activeFlag }
    val createdByUser = varchar("created_by_user").bindTo { it.createdByUser }
    val createdByDate = varchar("created_by_date").bindTo { it.createdByDate }
    val modifiedByUser = varchar("modofied_by_user").bindTo { it.modifiedByUser }
    val modifiedByDate = varchar("modified_by_date").bindTo { it.modifiedByDate }

}
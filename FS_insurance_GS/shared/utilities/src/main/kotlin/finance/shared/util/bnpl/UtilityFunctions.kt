package finance.shared.util.bnpl

import finance.shared.entities.bnpl.EmiInterestRateMaster
import finance.shared.entities.bnpl.schemas.EmiInterestRatesMaster
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.upperCase
import java.math.BigDecimal
import java.math.RoundingMode

object UtilFunctions {
    fun discountingCalculation(
        merchantId: String,
        lenderId: String,
        amount: Double
    ): DiscountDetails {

        val lenderDiscountPercentageForBNPL = transaction {
            EmiInterestRateMaster.find {
                (EmiInterestRatesMaster.merchantId eq merchantId) and (EmiInterestRatesMaster.lenderId eq lenderId) and (EmiInterestRatesMaster.status.upperCase() eq "ACTIVE")
            }
                .firstOrNull()?.lenderDiscount
        } ?: 0.0

        val loanAmountAfterDiscount = roundToTwoDecimal(amount / (1 + ((lenderDiscountPercentageForBNPL / 100) / 12)))
        val calculatedDiscount = roundToTwoDecimal(amount - loanAmountAfterDiscount)
        return DiscountDetails(
            calculatedDiscount, lenderDiscountPercentageForBNPL, loanAmountAfterDiscount
        )
    }
}

data class DiscountDetails(
    val lenderDiscount: Double,
    val lenderDiscountPercent: Double,
    val loanAmountAfterDiscount: Double
)

fun roundToTwoDecimal(value: Double?): Double {
    if (value == null) {
        return 0.0
    }
    var roundedValue = BigDecimal(value.toString());
    roundedValue = roundedValue.setScale(2, RoundingMode.HALF_EVEN);
    return roundedValue.toDouble()
}
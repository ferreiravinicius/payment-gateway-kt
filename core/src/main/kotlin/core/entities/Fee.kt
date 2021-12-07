package core.entities

import java.math.BigDecimal

class Fee(
    val company: Company,
    val installment: Int = 1,
    val withdrawDays: Int,
    val fixedAmount: BigDecimal = BigDecimal(0),
    val percentageAmount: BigDecimal = BigDecimal(0),
    val paymentMethod: PaymentMethod,
)

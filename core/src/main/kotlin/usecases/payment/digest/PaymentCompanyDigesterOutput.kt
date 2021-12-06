package app.usecases.payment.digest

import java.math.BigDecimal

data class FeeDigesterOutput(
    val installment: Int,
    val withdrawDays: Int,
    val fixedAmount: BigDecimal?,
    val percentageAmount: BigDecimal?,
)

data class PaymentMethodDigesterOutput(
    val description: String,
    val fees: List<FeeDigesterOutput>,
    val hasInstallmentAvailable: Boolean,
    val hasMultipleWithdrawOptions: Boolean,
)

data class PaymentCompanyDigesterOutput(
    val name: String,
    val paymentMethods: List<PaymentMethodDigesterOutput>,
)
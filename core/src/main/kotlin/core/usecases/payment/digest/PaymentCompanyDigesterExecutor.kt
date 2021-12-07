package core.usecases.payment.digest

import core.contracts.PaymentGatewayStore
import core.entities.Fee
import core.errors.NotFoundError
import java.math.RoundingMode

class PaymentCompanyDigesterExecutor(private val store: PaymentGatewayStore) : PaymentCompanyDigesterUseCase {

    override fun digest(companyName: String): Result<PaymentCompanyDigesterOutput> {
        val fees = store.findAllCompanyFees(companyName)

        if (fees.isEmpty()) {
            val error = NotFoundError("A empresa especificada não existe ou não possuí taxas cadastradas")
            return Result.failure(error)
        }

        val digestOutput = createDigesterOutput(fees)
        return Result.success(digestOutput)
    }

    private fun createDigesterOutput(fees: List<Fee>): PaymentCompanyDigesterOutput {
        val currentCompany = fees.first().company
        return PaymentCompanyDigesterOutput(
            name = currentCompany.name,
            paymentMethods = fees.groupBy { it.paymentMethod }.map { item ->
                PaymentMethodDigesterOutput(
                    description = item.key.description,
                    fees = item.value.map { fee ->
                        FeeDigesterOutput(
                            installment = fee.installment,
                            withdrawDays = fee.withdrawDays,
                            fixedAmount = fee.fixedAmount.setScale(2, RoundingMode.HALF_UP),
                            percentageAmount = fee.percentageAmount.setScale(2, RoundingMode.HALF_UP),
                        )
                    },
                    availableInstallments = item.value.map { fee -> fee.installment }.distinct(),
                    availableWithdraws = item.value.map { fee -> fee.withdrawDays }.distinct(),
                )
            }
        )
    }
}
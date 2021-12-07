package core.usecases.payment.digest

sealed interface PaymentCompanyDigesterUseCase {
    fun digest(companyName: String): Result<PaymentCompanyDigesterOutput>
}
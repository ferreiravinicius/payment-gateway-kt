package app.entities

data class PaymentGateway(
    val company: Company,
    val paymentMethods: List<PaymentMethod> = emptyList(),
)

data class Installment(
    val times: Int,
    val extraFee: Fee
)


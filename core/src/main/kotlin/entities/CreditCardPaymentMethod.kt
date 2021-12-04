package app.entities

class CreditCardPaymentMethod(
    override val description: String = "Cartão de Crédito",
    override val fees: List<Fee>,
    override val withdraws: List<Withdraw> = emptyList(),
    override val installments: List<Installment> = emptyList()
) : PaymentMethod, Installable
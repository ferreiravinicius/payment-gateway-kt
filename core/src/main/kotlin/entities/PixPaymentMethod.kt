package app.entities

class PixPaymentMethod(
    override val description: String = "Pix",
    override val fees: List<Fee>,
    override val withdraws: List<Withdraw> = emptyList()
) : PaymentMethod
package app.entities

class PaperPaymentMethod(fees: List<Fee>, withdraws: List<Withdraw> = emptyList()) : PaymentMethod {
    override val description: String = "Boleto"
    override val fees: List<Fee> = fees
    override val withdraws: List<Withdraw> = withdraws
}
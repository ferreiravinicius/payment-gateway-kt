package app.entities

interface PaymentMethod {
    val description: String
    val fees: List<Fee>
    val withdraws: List<Withdraw>
}
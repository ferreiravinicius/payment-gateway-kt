package entities

enum class PaymentMethod(val description: String) {
    PIX("Pix"),
    PAPER("Boleto"),
    CREDIT_CARD("Cartão de Crédito"),
}
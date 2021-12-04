package app

import app.entities.*
import java.math.BigDecimal

fun main() {

    val gateway = makeMercadoPago();
    println("Empresa: ${gateway.company.name}")

    val allPaymentMethods = gateway.paymentMethods
    for (paymentMethod in allPaymentMethods) {
        println("> ${paymentMethod.description}")

        println("- Disponibilidade")
        for (withdraw in paymentMethod.withdraws) {
            println("${withdraw.text}")
        }
    }
}

fun makeMercadoPago(): PaymentGateway {
    return PaymentGateway(
        company = Company(name = "Mercado Pago"),
        paymentMethods = listOf(
            PixPaymentMethod(
                fees = listOf(PercentFee(BigDecimal(0.99))),
                withdraws = listOf(Withdraw(days = 0, ZeroFee()))
            ),
            PaperPaymentMethod(
                fees = listOf(FixedAmountFee(BigDecimal(3.49))),
                withdraws = listOf(Withdraw(days = 0, ZeroFee()))
            ),
            CreditCardPaymentMethod(
                fees = listOf(PercentFee(BigDecimal(3.99))),
                withdraws = listOf(
                    Withdraw(days = 30, ZeroFee()),
                    Withdraw(days = 14, PercentFee(BigDecimal(0.5))),
                    Withdraw(days = 30, PercentFee(BigDecimal(1.0))),
                )
            )
        ),
    )
}

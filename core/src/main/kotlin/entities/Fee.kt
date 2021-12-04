package app.entities

import java.math.BigDecimal

interface Fee : Described {
    fun apply(amount: BigDecimal): BigDecimal
}
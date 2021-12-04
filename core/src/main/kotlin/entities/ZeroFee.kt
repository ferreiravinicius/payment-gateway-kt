package app.entities

import java.math.BigDecimal

class ZeroFee : Fee {

    override fun apply(amount: BigDecimal): BigDecimal {
        return amount
    }

    override val text: String
        get() = "Sem taxa";
}
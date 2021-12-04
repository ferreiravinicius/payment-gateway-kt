package app.entities

data class Withdraw(val days: Int, val extraFee: Fee) : Described {

    private val descriptionDays = when (days) {
        0 -> "Na hora"
        else -> "Em $days dias"
    }

    private val descriptionFee = when (extraFee) {
        is ZeroFee -> "sem taxa adicional"
        else -> "com taxa adicional de ${extraFee.text}"
    }

    override val text: String = "$descriptionDays $descriptionFee"
    override fun toString(): String = text
}
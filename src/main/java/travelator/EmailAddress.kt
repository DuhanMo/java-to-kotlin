package travelator

data class EmailAddress(
    val localPart: String,
    val domain: String
) {

    override fun toString(): String = "$localPart@$domain"

    companion object {
        fun parse(value: String): EmailAddress? =
            value.splitAroundLast('@')
                ?.let { (leftPart, rightPart) ->
                    EmailAddress(leftPart, rightPart)
                }

        private fun String.splitAroundLast(divider: Char): Pair<String, String>? =
            lastIndexOf(divider).let { atIndex ->
                if ((atIndex < 1 || atIndex == length - 1)) {
                    return null
                } else {
                    substring(0, atIndex) to substring(atIndex + 1)
                }
            }
    }
}
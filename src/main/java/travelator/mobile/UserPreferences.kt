package travelator.mobile

import java.util.*

class UserPreferences @JvmOverloads constructor(
    @JvmField var greeting: String = "Hello",
    @JvmField var locale: Locale = Locale.UK,
    @JvmField var currency: Currency = Currency.getInstance(Locale.UK)
)
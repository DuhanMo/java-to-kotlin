package travelator.hotels

import org.junit.jupiter.api.Test
import travelator.HasPrice
import travelator.HasRating
import travelator.HasRelevance
import travelator.byPriceLowToHigh
import travelator.byRating
import travelator.byRelevance
import travelator.byValue
import travelator.withoutItemAt
import travelator.sorted

class ShortlistScenarioTest {
    data class HotelSearchResult(
        val name: String,
        override val relevance: Double,
        override val price: Int,
        override val rating: Double
    ) : HasRelevance, HasPrice, HasRating

    val theGrand = HotelSearchResult(
        name = "The Grand",
        relevance = 1.0,
        price = 300,
        rating = 4.8
    )

    val sheridanImperial = HotelSearchResult(
        name = "Sheridan Imperial",
        relevance = 0.8,
        price = 400,
        rating = 4.9
    )

    val artHotel = HotelSearchResult(
        name = "Art Hotel",
        relevance = 0.6,
        price = 200,
        rating = 3.9
    )

    @Test
    fun scenario() {
        val hotels = shortlistOf(theGrand, sheridanImperial, artHotel)
        val hotelByRelevance = hotels.sorted(byRelevance())
        show(hotelByRelevance, "By Relevance")
        val hotelsByPrice = hotels.sorted(byPriceLowToHigh())
        show(hotelsByPrice, "By Price (low to high)")

        println("Rejecting: ${hotelsByPrice[0].name}")
        val desirableHotels = hotelsByPrice.withoutItemAt(0)
        show(desirableHotels, "Remaining shortlist")

        val desirableHotelsByRating = desirableHotels.sorted(byRating())
        show(desirableHotelsByRating, "By rating")
        val desirableHotelsByValue = desirableHotels.sorted(byValue())
        show(desirableHotelsByValue, "By value")
        println("Chosen: ${desirableHotelsByValue[0].name}")
    }

    private fun show(hotels: List<HotelSearchResult>, ordering: String) {
        println("$ordering: ${hotels.map { it.name }.joinToString(", ")}")
    }

    private fun <T> shortlistOf(vararg items: T): List<T> =
        java.util.List.of(*items)
}
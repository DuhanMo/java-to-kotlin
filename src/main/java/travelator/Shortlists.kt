package travelator

import java.util.Comparator.comparing
import java.util.Comparator.comparingDouble

fun <T> Iterable<T>.sorted(ordering: Comparator<in T>) =
    sortedWith(ordering)

fun <T> List<T>.withoutItemAt(index: Int) =
    take(index) + drop(index + 1)

fun byRating(): Comparator<HasRating> =
    comparingDouble(HasRating::rating).reversed()

fun byPriceLowToHigh(): Comparator<HasPrice> =
    comparing(HasPrice::price)

fun <T> byValue(): Comparator<T> where T : HasPrice, T : HasRating =
    comparingDouble { t: T -> t.rating / t.price }.reversed()

fun byRelevance(): Comparator<HasRelevance> =
    comparingDouble(HasRelevance::relevance).reversed()

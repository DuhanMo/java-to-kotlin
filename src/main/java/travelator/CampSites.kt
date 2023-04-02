package travelator

fun Iterable<CampSite>.sitesInRegion(
    countryISO: String,
    region: String?
): Set<CampSite> {
    return filter { site ->
        site.isIn(countryISO, region)
    }.toSet()
}

private fun CampSite.isIn(countryISO: String, region: String? = null) =
    countryCode == countryISO &&
            region?.equals(this.region, ignoreCase = true) ?: true
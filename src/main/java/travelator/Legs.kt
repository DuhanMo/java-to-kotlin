package travelator

import java.time.Duration

fun longestLegOver(legs: List<Leg>, duration: Duration) =
    legs.maxByOrNull(Leg::plannedDuration)
        ?.let {
            if (it.plannedDuration > duration) {
                it
            } else
                null
        }
package com.dara.gitty.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
fun String.toTimeAgo(): String {
    val parsedDateTime = LocalDateTime.parse(this.dropLast(1))

    val dateTimeInstant = parsedDateTime.atZone(ZoneId.of("UTC")).toInstant()

    val now = Instant.now()
    val minutes = ChronoUnit.MINUTES.between(dateTimeInstant, now)
    val hours = ChronoUnit.HOURS.between(dateTimeInstant, now)
    val days = ChronoUnit.DAYS.between(dateTimeInstant, now)
    val weeks = days / 7
    val months = ChronoUnit.MONTHS.between(
        dateTimeInstant.atZone(ZoneId.systemDefault()),
        now.atZone(ZoneId.systemDefault())
    )
    val years = ChronoUnit.YEARS.between(
        dateTimeInstant.atZone(ZoneId.systemDefault()),
        now.atZone(ZoneId.systemDefault())
    )

    return when {
        years > 0 -> "$years year${if (years > 1) "s" else ""} ago"
        months > 0 -> "$months month${if (months > 1) "s" else ""} ago"
        weeks > 0 -> "$weeks week${if (weeks > 1) "s" else ""} ago"
        days > 0 -> "$days day${if (days > 1) "s" else ""} ago"
        hours > 0 -> "$hours hour${if (hours > 1) "s" else ""} ago"
        minutes > 0 -> "$minutes minute${if (minutes > 1) "s" else ""} ago"
        else -> "just now"
    }
}

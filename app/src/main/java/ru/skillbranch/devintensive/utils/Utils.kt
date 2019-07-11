package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.TimeUnits


object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        if (firstName.isNullOrEmpty()) firstName = null
        var lastName = parts?.getOrNull(1)
        if (lastName.isNullOrEmpty()) lastName = null
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String? {
        val chars = mapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya",
            " " to divider)

        var result = ""
        payload.replace(" ", divider)
//            .toCharArray()
            .forEach {
                val symbol = if(!chars[(it.toString().toLowerCase())].isNullOrEmpty()) chars[(it.toString().toLowerCase())] else it.toString()
                result += if (it.isUpperCase()) symbol?.capitalize() else symbol
            }
        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        firstName?.trim()
        lastName?.trim()
        return when {
            firstName?.trim().isNullOrEmpty() && lastName?.trim().isNullOrEmpty() -> null
            !firstName?.trim().isNullOrEmpty() && lastName?.trim().isNullOrEmpty() -> firstName?.substring(
                0,
                1
            )?.toUpperCase()
            firstName?.trim().isNullOrEmpty() && !lastName?.trim().isNullOrEmpty() -> lastName?.substring(
                0,
                1
            )?.toUpperCase()
            else -> firstName?.substring(0, 1)?.toUpperCase() + lastName?.substring(0, 1)?.toUpperCase()
        }
    }

//    fun plurals(i: Long, timeunit: TimeUnits, context: Context): String {
//        val j: Int = i.toInt()%100
//        return when (timeunit) {
//            TimeUnits.SECOND -> context.resources.getQuantityString(R.plurals.seconds_plur, j, j)
//            TimeUnits.MINUTE -> context.resources.getQuantityString(R.plurals.minutes_plur, j, j)
//            TimeUnits.HOUR -> context.resources.getQuantityString(R.plurals.hours_plur, j, j)
//            TimeUnits.DAY -> context.resources.getQuantityString(R.plurals.days_plur, j, j)
//        }
//    }

    fun plurals(i: Long, timeunit: TimeUnits): String {

        val j = i % 10

        return if(j in 1..1) {
            when(timeunit) {
                TimeUnits.SECOND ->  "$i секунду"
                TimeUnits.MINUTE ->  "$i минуту"
                TimeUnits.HOUR ->  "$i час"
                TimeUnits.DAY ->  "$i день"
            }
        } else if(j in 2..4) {
            when(timeunit) {
                TimeUnits.SECOND ->  "$i секунды"
                TimeUnits.MINUTE ->  "$i минуты"
                TimeUnits.HOUR ->  "$i часа"
                TimeUnits.DAY ->  "$i дня"
            }
        } else {
            when(timeunit) {
                TimeUnits.SECOND ->  "$i секунд"
                TimeUnits.MINUTE ->  "$i минут"
                TimeUnits.HOUR ->  "$i часов"
                TimeUnits.DAY ->  "$i дней"
            }
        }
    }
}
package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

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
}
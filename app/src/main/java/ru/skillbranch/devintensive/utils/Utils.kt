package ru.skillbranch.devintensive.utils

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        firstName?.trim()
        lastName?.trim()
        return when {
            firstName?.trim().isNullOrEmpty() && lastName?.trim().isNullOrEmpty() -> null
            !firstName?.trim().isNullOrEmpty() && lastName?.trim().isNullOrEmpty() -> firstName?.substring(0,1)?.toUpperCase() + null
            firstName?.trim().isNullOrEmpty() && !lastName?.trim().isNullOrEmpty() -> null + lastName?.substring(0,1)?.toUpperCase()
            else -> firstName?.substring(0,1)?.toUpperCase() + lastName?.substring(0,1)?.toUpperCase()
        }
    }
}
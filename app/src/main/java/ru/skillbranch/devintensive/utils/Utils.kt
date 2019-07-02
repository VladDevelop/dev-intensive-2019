package ru.skillbranch.devintensive.utils

object Utils {

    //TODO FIX ME
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        firstName?.trim()
        lastName?.trim()
        return when {
            firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> null
            !firstName.isNullOrEmpty() && lastName.isNullOrEmpty() -> firstName.substring(0,1).toUpperCase()
            firstName.isNullOrEmpty() && !lastName.isNullOrEmpty() -> lastName.substring(0,1).toUpperCase()
            else -> firstName?.substring(0,1)?.toUpperCase() + lastName?.substring(0,1)?.toUpperCase()
        }
    }
}
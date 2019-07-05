package ru.skillbranch.devintensive.extensions


fun String.truncate(str: String, length: Int = 16): String {
    if (str.length < length) {
        return str.trimEnd()
    } else {
        val truncatedStr = str.substring(0, length) + "..."
        return truncatedStr
    }
}
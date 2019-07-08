package ru.skillbranch.devintensive.extensions


//fun String.truncate(str: String, length: Int = 16): String {
//
//    if (str.length < length) {
//        return str.trimEnd()
//    } else if (str.substring(length - 1, length) == " "){
//        str.trimEnd()
//        return str.substring(0, length) + "..."
//    } else {
//        return str.substring(0, length) + "..."
//    }
//}
fun String.truncate(length: Int = 16): String {
    this.trimEnd()
    if (this.substring(length - 1, length) == " ") {
        var truncatedStr = this.trimEnd()
        if (truncatedStr.length < length) {
            return truncatedStr
        }
        return this.substring(0, length - 1) + "..."
    } else {
        return this.substring(0, length) + "..."
    }
}

fun String.stripHtml() = this.replace(Regex("<[^<]*?>|&\\d+;"), "").replace(Regex("\\s+"), " ")
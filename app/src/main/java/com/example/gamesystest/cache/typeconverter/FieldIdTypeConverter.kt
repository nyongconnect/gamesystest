package com.example.gamesystest.cache.typeconverter

import androidx.room.TypeConverter

class FieldIdTypeConverter {

    @TypeConverter
    fun toList(fieldString: String): List<String> {
        return fieldString.split("*").map {
            it.toString() }
    }

    @TypeConverter
    fun toString(field: List<String>): String {

        var convertedString: String = " "

        field.forEachIndexed { index, _ ->
            convertedString += field[index].toString().plus("*")

        }

        return convertedString.trim()
    }
}
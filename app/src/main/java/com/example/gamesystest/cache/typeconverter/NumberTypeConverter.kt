package com.example.gamesystest.cache.typeconverter

import androidx.room.TypeConverter

class NumberTypeConverter {

    @TypeConverter
    fun toList(fieldString: String): List<Double> {
        return fieldString.split(",").map {
            it.toDouble() }
    }

    @TypeConverter
    fun toString(field: List<Double>): String {

        var convertedString: String = " "

        field.forEachIndexed { index, _ ->
            convertedString += field[index].toString().plus(",")

        }

        return convertedString.trim()
    }
}

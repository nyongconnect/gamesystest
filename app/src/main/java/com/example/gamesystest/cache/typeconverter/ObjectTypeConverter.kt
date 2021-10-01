package com.example.gamesystest.cache.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*



inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)

public class DataTypeConverter {
    val  gson: Gson = Gson()
    @TypeConverter
    fun  stringToList(dataw: String): List<CurrencyLocal> {
        if (dataw == null) {
            return Collections.emptyList();
        }
        return gson.fromJson(dataw)
    }

    @TypeConverter
    fun ListToString(someObjects: List<CurrencyLocal> ): String {
        return gson.toJson(someObjects);
    }
}
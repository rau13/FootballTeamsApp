package com.example.teamsapp.db

import androidx.room.TypeConverter
import com.example.teamsapp.models.Country
import com.example.teamsapp.models.Data
import org.json.JSONObject

class Converters {
    @TypeConverter
    fun fromCountry(country: Country): String {
        return JSONObject().apply {
            put("continent", country.continent)
            put("country_code", country.country_code)
            put("country_id", country.country_id)
            put("name",country.name)
        }.toString()
    }

    @TypeConverter
    fun toCountry(country: String): Country {
        val json = JSONObject(country)
        return Country(json.getString("continent"), json.getString("country_code"), json.getInt("country_id"), json.getString("name") )
    }

    @TypeConverter
    fun fromData(data: Data): String {
        return JSONObject().apply {
            put("common_name", data.common_name)
            put("country", data.country)
            put("logo", data.logo)
            put("name", data.name)
            put("short_code", data.short_code)
            put("team_id", data.team_id)
        }.toString()
    }

    @TypeConverter
    fun toData(data: String): Data {
        val json = JSONObject(data)
        return Data(json.getString("common_name"),
            json.get("country") as Country, json.getString("logo"), json.getString("name"), json.getString("short_code"), json.getInt("team_id") )
    }
}
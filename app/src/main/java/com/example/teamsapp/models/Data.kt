package com.example.teamsapp.models

import androidx.room.*
import com.example.teamsapp.db.Converters
import javax.annotation.Nullable


@Entity(tableName = "teams")
data class Data(
    val common_name: String?,
    @TypeConverters(Converters::class)
    val country: Country,
    val logo: String,
    val name: String,
    val short_code: String,
    @PrimaryKey
    val team_id: Int
)
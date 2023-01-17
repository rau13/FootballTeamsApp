package com.example.teamsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.teamsapp.models.Data
import com.example.teamsapp.models.Teams

@Database(entities = [Data::class], version = 1)
@TypeConverters(Converters::class)
abstract class TeamsDatabase : RoomDatabase() {
    abstract fun teamsDao() : TeamsDao
}
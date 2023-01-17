package com.example.teamsapp.db

import androidx.room.*
import com.example.teamsapp.models.Data
import com.example.teamsapp.models.Teams
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

@Dao
interface TeamsDao {

    @Query("SELECT * FROM teams")
    fun getTeams() : Flow<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(team: Data)

    @Query("DELETE FROM teams")
    suspend fun deleteAllTeams()
}
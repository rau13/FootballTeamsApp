package com.example.teamsapp.repository

import android.util.Log
import androidx.room.withTransaction
import com.example.teamsapp.api.ApiService
import com.example.teamsapp.db.TeamsDatabase
import com.example.teamsapp.helper.Constants
import com.example.teamsapp.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject


class TeamsRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val db: TeamsDatabase
    ){
    private val teamsDao = db.teamsDao()

    fun getTeams() = networkBoundResource(
        query = {
            teamsDao.getTeams()
        },
        fetch = {
            delay(4000)
            apiService.getTeamsList()
        },
        saveFetchResult = { teams ->
            db.withTransaction {
                teamsDao.deleteAllTeams()
                for (i in teams.body()!!.data){
                    db.teamsDao().insertTeams(i.copy())
                }
            }

        }
    )
}

package com.example.teamsapp.api

import com.example.teamsapp.models.Data
import com.example.teamsapp.models.Teams
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/soccer/teams?apikey=92a74c50-94ef-11ed-82fc-5506287a2e26&country_id=48")
    suspend fun getTeamsList() : Response<Teams>
}
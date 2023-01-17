package com.example.teamsapp.api

import com.example.teamsapp.models.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {
    @GET("api/v1/soccer/teams/{team}?apikey=92a74c50-94ef-11ed-82fc-5506287a2e26&country_id=48")
    suspend fun getTeamDetails(@Path("team") team: String) : Response<Data>
}
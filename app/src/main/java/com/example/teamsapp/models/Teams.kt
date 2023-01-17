package com.example.teamsapp.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class Teams(
    val `data`: List<Data>
)
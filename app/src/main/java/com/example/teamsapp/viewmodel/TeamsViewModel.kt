package com.example.teamsapp.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.teamsapp.helper.Constants
import com.example.teamsapp.models.Data
import com.example.teamsapp.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TeamsViewModel

@Inject
constructor(private val repository: TeamsRepository) : ViewModel() {
    val teams = repository.getTeams().asLiveData()
}
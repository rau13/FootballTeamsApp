package com.example.teamsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamsapp.adapters.TeamsAdapter
import com.example.teamsapp.databinding.ActivityTeamListScreenBinding
import com.example.teamsapp.helper.Constants
import com.example.teamsapp.util.Resource
import com.example.teamsapp.viewmodel.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TeamListScreen : AppCompatActivity() {

    private lateinit var binding : ActivityTeamListScreenBinding
    private val viewModel : TeamsViewModel by viewModels()
    private lateinit var TeamsAdapter : TeamsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.swiperefresh.setOnRefreshListener {
            binding.swiperefresh.isRefreshing = false
            initRv()
        }
        initRv()
    }

    private fun initRv(){
        TeamsAdapter = TeamsAdapter()
        binding.rvTeamsList.apply {
            adapter = TeamsAdapter
            layoutManager = LinearLayoutManager(this@TeamListScreen, LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }
        viewModel.teams.observe(this) { teams ->
            TeamsAdapter.teams = teams.data!!
            Log.d(Constants.TAG, teams.data.toString())
            binding.progressBar.isVisible = teams is Resource.Loading && teams.data.isNullOrEmpty()
            binding.textView2.isVisible = teams is Resource.Error && teams.data.isNullOrEmpty()
            binding.textView2.text = teams.error?.localizedMessage
        }
    }
}
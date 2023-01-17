package com.example.teamsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.teamsapp.databinding.ActivityTeamDetailsBinding

class TeamDetails : AppCompatActivity() {
    private lateinit var shortCode : String
    private lateinit var teamName : String
    private lateinit var logo : String
    private lateinit var country : String
    private lateinit var binding : ActivityTeamDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        shortCode = intent.getStringExtra("shortCode").toString()
        teamName = intent.getStringExtra("teamName").toString()
        logo = intent.getStringExtra("logo").toString()
        country = intent.getStringExtra("country").toString()
        binding.teamName.text = teamName
        binding.shortCode.text = shortCode
        binding.teamCountry.text = country
        binding.teamDetailsLogo.load(logo)
    }
}
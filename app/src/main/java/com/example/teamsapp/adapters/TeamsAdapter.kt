package com.example.teamsapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.teamsapp.ui.TeamDetails
import com.example.teamsapp.databinding.RvTeamsListItemBinding
import com.example.teamsapp.models.Data


class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>() {

    class TeamsViewHolder(val binding: RvTeamsListItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.team_id == newItem.team_id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var teams : List<Data>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder(
            RvTeamsListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val currentTeam = teams[position]
        holder.binding.apply {
            val context = holder.binding.root.context
            val shortCode = currentTeam.short_code
            val teamName = currentTeam.name
            val logo = currentTeam.logo
            val country = currentTeam.country.name
            tvName.text = teamName
            tvCountry.text = country
            teamIcon.load(currentTeam.logo)
            teamCard.setOnClickListener {
                val intent = Intent(context, TeamDetails::class.java)
                intent.putExtra("shortCode", shortCode)
                intent.putExtra("teamName", teamName)
                intent.putExtra("logo",logo)
                intent.putExtra("country",country)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
       return teams.size
    }
}
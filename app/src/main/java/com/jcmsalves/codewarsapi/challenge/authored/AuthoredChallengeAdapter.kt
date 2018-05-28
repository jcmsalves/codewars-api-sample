package com.jcmsalves.codewarsapi.challenge.authored

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import kotlinx.android.synthetic.main.authored_challenge_item_view.view.*
import javax.inject.Inject

class AuthoredChallengeAdapter @Inject constructor(private val challengeClickedListener: (String) -> Unit)
    : RecyclerView.Adapter<AuthoredChallengeAdapter.ViewHolder>() {

    private val challenges = ArrayList<AuthoredChallenge>()

    override fun getItemCount(): Int = challenges.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.authored_challenge_item_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(challenges[position])

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(challenge: AuthoredChallenge) {

            itemView.challengeNameTv.text = challenge.name
            itemView.challengeDescriptionTv.text = challenge.description
            itemView.challengeLanguagesTv.text = challenge.languages.joinToString(separator = " | ")
            itemView.challengeTagsTv.text = challenge.tags.joinToString(separator = " | ")

            itemView.setOnClickListener { v -> challengeClickedListener.invoke(challenge.id) }
        }
    }

    fun addChallenges(challengesList: List<AuthoredChallenge>) {
        this.challenges.clear()
        this.challenges.addAll(challengesList)
        notifyDataSetChanged()
    }
}

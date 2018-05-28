package com.jcmsalves.codewarsapi.challenge.completed

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import kotlinx.android.synthetic.main.completed_challenge_item_view.view.*
import javax.inject.Inject

class CompletedChallengeAdapter @Inject constructor(private val challengeClickedListener: (String) -> Unit)
    : RecyclerView.Adapter<CompletedChallengeAdapter.ViewHolder>() {

    private val challenges = ArrayList<CompletedChallenge>()

    override fun getItemCount(): Int = challenges.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.completed_challenge_item_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(challenges[position])

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(challenge: CompletedChallenge) {
            itemView.challengeNameTv.text = if (challenge.name.isBlank()) challenge.id else challenge.name
            itemView.challengeSlugTv.text = if (challenge.slug.isBlank()) challenge.id else challenge.slug
            itemView.challengeCompletedAtTv.text = challenge.completedAt
            itemView.challengeLanguagesTv.text = challenge.completedLanguages.joinToString(separator = " | ")

            itemView.setOnClickListener { v -> challengeClickedListener.invoke(challenge.id) }
        }
    }

    fun addChallenges(challengesList: List<CompletedChallenge>) {
        this.challenges.clear()
        this.challenges.addAll(challengesList)
        notifyDataSetChanged()
    }
}

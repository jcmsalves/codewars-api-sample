package com.jcmsalves.codewarsapi.user

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.domain.user.User
import kotlinx.android.synthetic.main.member_item_view.view.*
import javax.inject.Inject

class UserAdapter @Inject constructor(private val userClickedListener: (String) -> Unit)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val users = ArrayList<User>()

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.member_item_view, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(users[position])

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            itemView.memberNameTv.text = if (user.name.isNullOrBlank()) user.username else user.name
            itemView.memberRankTv.text = user.overallRank.name
            itemView.memberLeaderboardTv.text = user.leaderboardPosition.toString()

            val bestLanguage = user.languages.sortedBy { it.rank.score }.last()
            val bestLanguageDisplay = """${bestLanguage.languageName} | score: ${bestLanguage.rank.score} """
            itemView.memberBestLanguageTv.text = bestLanguageDisplay

            itemView.setOnClickListener { v -> userClickedListener.invoke(user.username) }
        }
    }

    fun addUsers(usersList: List<User>) {
        this.users.clear()
        this.users.addAll(usersList)
        notifyDataSetChanged()
    }
}

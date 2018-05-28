package com.jcmsalves.codewarsapi.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.ViewModelFactory
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.user.viewmodel.SearchedUserState
import com.jcmsalves.codewarsapi.user.viewmodel.UserSearchedViewModel
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.member_item_view.*
import javax.inject.Inject



class UsersActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        (application as CodewarsApp).applicationComponent.inject(this)

        val userSearchedViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserSearchedViewModel::class.java)

        searchIv.setOnClickListener { v ->
            if (searchInputEt.text.isNotBlank()) userSearchedViewModel.searchUser(searchInputEt.text.toString())
        }

        userSearchedViewModel.searchedUser.observe(this, Observer { it ->
            when (it) {
                is SearchedUserState.Loading -> showSearchLoading()
                is SearchedUserState.Error -> showError()
                is SearchedUserState.Data -> showSearchedUser(it.user)
            }
        })
    }

    private fun showSearchedUser(user: User) {
        searchPb.visibility = View.GONE

        memberNameTv.text = if (user.name.isNullOrBlank()) user.username else user.name
        memberRankTv.text = user.overallRank.name
        memberLeaderboardTv.text = user.leaderboardPosition.toString()

        val bestLanguage = user.languages.sortedBy { it.rank.score }.last()
        val bestLanguageDisplay = """${bestLanguage.languageName} | score: ${bestLanguage.rank.score} """
        memberBestLanguageTv.text = bestLanguageDisplay

        memberSearchedCv.visibility = View.VISIBLE
    }

    private fun showError() {
        searchPb.visibility = View.GONE
        Snackbar.make(usersActivityContainer, getString(R.string.members_activity_error_message), Snackbar.LENGTH_LONG).show()
    }

    private fun showSearchLoading() {
        memberSearchedCv.visibility = View.GONE
        searchPb.visibility = View.VISIBLE
    }
}

package com.jcmsalves.codewarsapi.challenge.authored

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.ViewModelFactory
import com.jcmsalves.codewarsapi.challenge.ChallengesActivity
import com.jcmsalves.codewarsapi.challenge.authored.viewmodel.AuthoredChallengesState
import com.jcmsalves.codewarsapi.challenge.authored.viewmodel.AuthoredChallengesViewModel
import com.jcmsalves.codewarsapi.domain.challenge.AuthoredChallenge
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.fragment_authored_challenges.*
import javax.inject.Inject

class AuthoredChallengesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    companion object {
        fun newInstance(username: String) = AuthoredChallengesFragment().apply {
            arguments = Bundle().apply { putString(ChallengesActivity.EXTRA_USERNAME, username) }
        }
    }

    private val challengeClickedListener: (String) -> Unit = { it ->
//        this.startActivity(Intent(activity, ChallengeDetailActivity::class.java).apply {
//            putExtra(ChallengesDetailActivity.EXTRA_CHALLENGE_ID, it)
//        })
    }

    private val challengeAdapter = AuthoredChallengeAdapter(challengeClickedListener)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context?.applicationContext as CodewarsApp).applicationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_authored_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireNotNull(arguments?.get(ChallengesActivity.EXTRA_USERNAME))

        val authoredChallengesViewModel = ViewModelProviders.of(this, viewModelFactory).get(AuthoredChallengesViewModel::class.java)
        val username = arguments!!.getString(ChallengesActivity.EXTRA_USERNAME)

        authoredChallengesRv.adapter = challengeAdapter
        authoredChallengesRv.layoutManager = LinearLayoutManager(activity)

        authoredChallengesViewModel.authoredChallenges.observe(this, Observer {it ->
            when (it) {
                is AuthoredChallengesState.Loading -> showLoading()
                is AuthoredChallengesState.Error -> showError()
                is AuthoredChallengesState.Data -> showChallenges(it.challenges)
            }
        })

        authoredChallengesViewModel.getAuthoredChallenges(username, true)
    }

    private fun showError() {
        authoredChallengesPb.visibility = View.GONE
        Snackbar.make(usersActivityContainer, getString(R.string.generic_error), Snackbar.LENGTH_LONG).show()
    }

    private fun showLoading() {
        authoredChallengesPb.visibility = View.VISIBLE
    }

    private fun showChallenges(challenges: List<AuthoredChallenge>) {
        authoredChallengesPb.visibility = View.GONE
        if (challenges.isEmpty()) {
            authoredChallengesRv.visibility = View.GONE
            noAuthoredChallengesTv.visibility = View.VISIBLE
        } else {
            noAuthoredChallengesTv.visibility = View.GONE
            authoredChallengesRv.visibility = View.VISIBLE
            challengeAdapter.addChallenges(challenges)
        }
    }
}

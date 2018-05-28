package com.jcmsalves.codewarsapi.challenge.completed

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
import com.jcmsalves.codewarsapi.challenge.completed.viewmodel.CompletedChallengesState
import com.jcmsalves.codewarsapi.challenge.completed.viewmodel.CompletedChallengesViewModel
import com.jcmsalves.codewarsapi.domain.challenge.CompletedChallenge
import kotlinx.android.synthetic.main.fragment_completed_challenges.*
import javax.inject.Inject

class CompletedChallengesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    companion object {
        fun newInstance(username: String) = CompletedChallengesFragment().apply {
            arguments = Bundle().apply { putString(ChallengesActivity.EXTRA_USERNAME, username) }
        }
    }

    private val challengeClickedListener: (String) -> Unit = { it ->
        //        this.startActivity(Intent(activity, ChallengeDetailActivity::class.java).apply {
        //              putExtra(ChallengesDetailActivity.EXTRA_CHALLENGE_ID, it)
        //        })
    }

    private val challengeAdapter = CompletedChallengeAdapter(challengeClickedListener)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context?.applicationContext as CodewarsApp).applicationComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_completed_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireNotNull(arguments?.get(ChallengesActivity.EXTRA_USERNAME))

        val completedChallengesViewModel = ViewModelProviders.of(this, viewModelFactory).get(CompletedChallengesViewModel::class.java)
        val username = arguments!!.getString(ChallengesActivity.EXTRA_USERNAME)

        completedChallengesRv.adapter = challengeAdapter
        completedChallengesRv.layoutManager = LinearLayoutManager(activity)

        completedChallengesViewModel.completedChallenges.observe(this, Observer { it ->
            when (it) {
                is CompletedChallengesState.Loading -> showLoading()
                is CompletedChallengesState.Error -> showError()
                is CompletedChallengesState.Data -> showChallenges(it.challenges)
            }
        })

        completedChallengesViewModel.getCompletedChallenges(username, true)
    }

    private fun showError() {
        completedChallengesPb.visibility = View.GONE
        Snackbar.make(completedChallengesContainer, getString(R.string.generic_error), Snackbar.LENGTH_LONG).show()
    }

    private fun showLoading() {
        completedChallengesPb.visibility = View.VISIBLE
    }

    private fun showChallenges(challenges: List<CompletedChallenge>) {
        completedChallengesPb.visibility = View.GONE
        if (challenges.isEmpty()) {
            completedChallengesRv.visibility = View.GONE
            noCompletedChallengesTv.visibility = View.VISIBLE
        } else {
            noCompletedChallengesTv.visibility = View.GONE
            completedChallengesRv.visibility = View.VISIBLE
            challengeAdapter.addChallenges(challenges)
        }
    }
}

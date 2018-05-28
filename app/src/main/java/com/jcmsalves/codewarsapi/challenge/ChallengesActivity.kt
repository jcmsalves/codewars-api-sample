package com.jcmsalves.codewarsapi.challenge

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.challenge.authored.AuthoredChallengesFragment
import com.jcmsalves.codewarsapi.challenge.completed.CompletedChallengesFragment
import kotlinx.android.synthetic.main.activity_challenges.*

class ChallengesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "EXTRA_USERNAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenges)
        actionBar?.title = "User Challenges"

        val authoredChallengesFragment = AuthoredChallengesFragment.newInstance()
        val completedChallengesFragment = CompletedChallengesFragment.newInstance()

        challengesBn.selectedItemId = 0
        addFragment(authoredChallengesFragment)

        challengesBn.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.action_list -> {
                        addFragment(authoredChallengesFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.action_map -> {
                        addFragment(completedChallengesFragment)
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            })
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment,
            fragment.javaClass.simpleName).commit()
    }
}

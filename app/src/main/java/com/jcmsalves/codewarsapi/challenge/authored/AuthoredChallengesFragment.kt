package com.jcmsalves.codewarsapi.challenge.authored

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.R

class AuthoredChallengesFragment : Fragment() {

    companion object {
        fun newInstance() = AuthoredChallengesFragment().apply {
            arguments = Bundle()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_authored_challenges, container, false)
    }
}

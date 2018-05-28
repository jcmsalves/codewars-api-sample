package com.jcmsalves.codewarsapi.challenge.completed

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcmsalves.codewarsapi.R

class CompletedChallengesFragment : Fragment() {

    companion object {
        fun newInstance() = CompletedChallengesFragment().apply {
            arguments = Bundle()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_completed_challenges, container, false)
    }
}

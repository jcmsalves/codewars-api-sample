package com.jcmsalves.codewarsapi.user

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jcmsalves.codewarsapi.CodewarsApp
import com.jcmsalves.codewarsapi.R
import com.jcmsalves.codewarsapi.domain.user.getuser.GetUserInteractor
import kotlinx.android.synthetic.main.activity_users.*
import javax.inject.Inject

class UsersActivity : AppCompatActivity() {

    @Inject
    lateinit var getUserInteractor: GetUserInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        (application as CodewarsApp).applicationComponent.inject(this)

        searchIv.setOnClickListener { v -> memberSearchedCv.visibility = View.VISIBLE }
        // TODO - remove testing code
//        whatever_button.setOnClickListener { v ->
//            getUserInteractor.execute(GetUserRequest("geeves", false))
//                .subscribe(
//                    { user: User? -> Toast.makeText(applicationContext, user.toString(), Toast.LENGTH_LONG).show() },
//                    { t: Throwable? -> Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show() })
//        }
    }
}

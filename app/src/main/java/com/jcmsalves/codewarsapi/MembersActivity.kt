package com.jcmsalves.codewarsapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jcmsalves.codewarsapi.domain.user.User
import com.jcmsalves.codewarsapi.domain.user.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_members.*
import javax.inject.Inject

class MembersActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_members)

        (application as CodewarsApp).applicationComponent.inject(this)

        // TODO - remove testing code
        whatever_button.setOnClickListener { v ->
            userRepository.getUser("jcmsalves", false)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {user: User? -> Toast.makeText(applicationContext, user.toString(), Toast.LENGTH_LONG).show() },
                    {t: Throwable? -> Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show() })
        }

    }

}

package com.jcmsalves.codewarsapi.data

import com.jcmsalves.codewarsapi.domain.RxJava2Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxJava2SchedulersImpl @Inject
constructor() : RxJava2Schedulers {

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun single(): Scheduler = Schedulers.single()

    override fun io(): Scheduler = Schedulers.io()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun trampoline(): Scheduler = Schedulers.trampoline()
}

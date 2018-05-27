package com.jcmsalves.codewarsapi.domain

import io.reactivex.Scheduler

interface RxJava2Schedulers {

    fun main(): Scheduler

    fun single(): Scheduler

    fun io(): Scheduler

    fun computation(): Scheduler

    fun trampoline(): Scheduler
}

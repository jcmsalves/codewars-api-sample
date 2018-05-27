package com.jcmsalves.codewarsapi.domain

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulers : RxJava2Schedulers {

    override fun main(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun single(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }
}

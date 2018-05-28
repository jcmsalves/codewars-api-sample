package com.jcmsalves.codewarsapi.domain

import io.reactivex.Observable

interface NoArgInteractor<RESULT> {

    fun execute(): Observable<RESULT>
}

package com.jcmsalves.codewarsapi.domain

import io.reactivex.Observable

interface Interactor<in REQUEST : InteractorRequest, RESULT> {

    fun execute(request: REQUEST): Observable<RESULT>
}

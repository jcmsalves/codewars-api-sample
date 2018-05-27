package com.jcmsalves.codewarsapi.domain

interface Mapper<in FROM, out TO> {

    fun map(from: FROM): TO
}

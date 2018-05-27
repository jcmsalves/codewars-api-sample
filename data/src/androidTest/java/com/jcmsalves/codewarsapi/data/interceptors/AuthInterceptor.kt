package com.jcmsalves.codewarsapi.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor : Interceptor {

    companion object {
        private const val API_KEY = "as5-tkZsC_diXqAV9wda"
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val requestBuilder = original.newBuilder()
            .addHeader("Authorization", API_KEY)
            .url(originalHttpUrl)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}

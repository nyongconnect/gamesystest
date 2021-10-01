package com.example.gamesystest.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder().apply {
            addHeader(AUTHORIZATION, TOKEN)
        }.build()

        return chain.proceed(newRequest)
    }

    companion object {
        const val TOKEN = "77adfa9227005e3825428483978a6f3e"
        const val AUTHORIZATION = "accessToken"
    }
}
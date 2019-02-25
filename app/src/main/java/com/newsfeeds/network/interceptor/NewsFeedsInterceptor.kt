package com.newsfeeds.network.interceptor

import com.newsfeeds.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response



class NewsFeedsInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
                .addHeader("Authorization", BuildConfig.API_KEY)
                .build()

        return chain.proceed(newRequest)
    }

}
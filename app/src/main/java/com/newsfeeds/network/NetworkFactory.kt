package com.newsfeeds.network

import com.newsfeeds.network.interceptor.NewsFeedsInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://newsapi.org"

class NetworkFactory {

    companion object {

        private lateinit var retrofit: Retrofit

        fun <T> getService(service: Class<T>): T {
            if (!::retrofit.isInitialized) {
                retrofit = NetworkFactory().getRetrofitClient()
            }
            return retrofit.create(service)
        }
    }

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun getOkHttpClient() = OkHttpClient.Builder()
            .addInterceptor(NewsFeedsInterceptor())
            .addInterceptor(getLoggingInterceptor())
            .build()

    private fun getLoggingInterceptor() =
            HttpLoggingInterceptor().setLevel(BODY)


}
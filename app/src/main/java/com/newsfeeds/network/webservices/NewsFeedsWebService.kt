package com.newsfeeds.network.webservices

import com.newsfeeds.network.models.TopHeadlinesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsFeedsWebService {

    @GET(TOP_HEADLINES)
    fun getHeadLineFor(@Query(QUERY_KEY_CATEGORY) category: String, @Query(QUERY_KEY_COUNTRY) country: String): Single<TopHeadlinesResponse>


    companion object Contract{
        const val TOP_HEADLINES = "/v2/top-headlines"

        const val QUERY_KEY_CATEGORY = "category"
        const val QUERY_KEY_COUNTRY = "country"
    }
}
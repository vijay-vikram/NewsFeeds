package com.newsfeeds.home.repositories

import com.newsfeeds.network.NetworkFactory
import com.newsfeeds.network.News
import com.newsfeeds.network.News.Category.*
import com.newsfeeds.network.News.Country.*
import com.newsfeeds.network.models.TopHeadlinesResponse
import com.newsfeeds.network.webservices.NewsFeedsWebService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HomeRepository {

    private var newsFeedsWebService: NewsFeedsWebService = NetworkFactory.getService(NewsFeedsWebService::class.java)

    fun fetchHeadlinesForBusiness(): Single<TopHeadlinesResponse> {
        return newsFeedsWebService.getHeadLineFor(BUSINESS.toString(), INDIA.toString())
                .subscribeOn(Schedulers.io())

    }

}
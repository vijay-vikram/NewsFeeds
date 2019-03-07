package com.newsfeeds.home.repositories

import android.content.Context
import androidx.room.Room
import com.newsfeeds.database.NewsFeedsDatabase
import com.newsfeeds.network.NetworkFactory
import com.newsfeeds.network.enums.News.Category.BUSINESS
import com.newsfeeds.network.enums.News.Country.INDIA
import com.newsfeeds.network.enums.Status
import com.newsfeeds.network.models.Article
import com.newsfeeds.network.webservices.NewsFeedsWebService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HomeRepository(private val context: Context) {

    private var newsFeedsWebService: NewsFeedsWebService = NetworkFactory.getService(NewsFeedsWebService::class.java)

    private var newsFeedsDao = Room.databaseBuilder(context.applicationContext,
            NewsFeedsDatabase::class.java, NewsFeedsDatabase.DATABASE_NAME)
            .build()
            .newsFeedsDao()

    fun fetchHeadlinesForBusiness(): Single<List<Article>> {
        return newsFeedsWebService.getHeadLineFor(BUSINESS.toString(), INDIA.toString())
                .subscribeOn(Schedulers.io())
                .map { topHeadlinesResponse ->
                    topHeadlinesResponse.articleList.forEach {
                        it.category = BUSINESS.getId()
                    }
                    topHeadlinesResponse
                }
                .doOnSuccess {
                    newsFeedsDao.insertAll(it.articleList)
                }
                .flatMap {
                    if (it.status == Status.OK.toString())
                        Single.just(it.articleList)
                    else
                        Single.error(Throwable(it.message))
                }
    }
}




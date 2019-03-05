package com.newsfeeds.home.contract

import com.newsfeeds.network.models.Article

interface HomeActivityContract{
    fun renderHeadlinesForBusiness(articleList: List<Article>)
    fun showBussinessNewsProgressBar()
    fun hideBusinessNewsProgressBar()
}
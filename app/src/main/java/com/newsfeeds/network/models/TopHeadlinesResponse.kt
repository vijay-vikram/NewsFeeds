package com.newsfeeds.network.models

import com.google.gson.annotations.SerializedName

class TopHeadlinesResponse(@SerializedName("articles") val articleList: List<Article>) : BaseResponse()
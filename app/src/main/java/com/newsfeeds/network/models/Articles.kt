package com.newsfeeds.network.models

import com.google.gson.annotations.SerializedName

data class Articles(@SerializedName("source") val source: Source,
                    @SerializedName("author") val authorName: String,
                    @SerializedName("title") val title: String,
                    @SerializedName("description") val description: String,
                    @SerializedName("url") val url: String,
                    @SerializedName("urlToImage") val imageUrl: String,
                    @SerializedName("publishedAt") val publishedAt: String,
                    @SerializedName("content") val content: String)
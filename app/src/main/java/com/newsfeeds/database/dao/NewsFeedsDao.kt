package com.newsfeeds.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.newsfeeds.network.models.Article
import com.newsfeeds.network.models.Article.Contract.TABLE_NAME

@Dao
interface NewsFeedsDao {

    @Insert
    fun insertAll(article: List<Article>)

    @Query("SELECT * FROM $TABLE_NAME")
    fun fetchHeadlinesForBusiness(): LiveData<List<Article>>
    
}
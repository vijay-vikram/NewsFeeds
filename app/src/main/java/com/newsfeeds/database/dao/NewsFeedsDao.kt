package com.newsfeeds.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.newsfeeds.network.models.Article
import com.newsfeeds.network.models.Article.Contract.COLUMN_CATEGORY
import com.newsfeeds.network.models.Article.Contract.COLUMN_PUBLISHED_AT
import com.newsfeeds.network.models.Article.Contract.TABLE_NAME

@Dao
interface NewsFeedsDao {

    @Insert
    fun insertAll(article: List<Article>)

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_CATEGORY LIKE :categoryId ORDER BY $COLUMN_PUBLISHED_AT DESC")
    fun fetchHeadlinesFor(categoryId: Int): LiveData<List<Article>>
    
}
package com.newsfeeds.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.newsfeeds.network.models.Article
import com.newsfeeds.network.models.Article.Contract.COLUMN_CATEGORY
import com.newsfeeds.network.models.Article.Contract.TABLE_NAME
import io.reactivex.Maybe

@Dao
interface NewsFeedsDao {

    @Insert
    fun insertAll(article: List<Article>)
    
}
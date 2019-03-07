package com.newsfeeds.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsfeeds.database.dao.NewsFeedsDao
import com.newsfeeds.network.models.Article

@Database(entities = [Article::class], version = 1)
abstract class NewsFeedsDatabase : RoomDatabase() {
    abstract fun newsFeedsDao(): NewsFeedsDao


    companion object Contract{
        const val DATABASE_NAME = "news-feeds"
    }

}
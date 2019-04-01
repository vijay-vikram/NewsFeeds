package com.newsfeeds.network.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.newsfeeds.network.models.Article.Contract.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Article(@PrimaryKey(autoGenerate = true) var id: Long,
                   @ColumnInfo(name = COLUMN_AUTHOR) @SerializedName("author") var authorName: String?,
                   @ColumnInfo(name = COLUMN_TITLE) @SerializedName("title") val title: String,
                   @ColumnInfo(name = COLUMN_DESCRIPTION) @SerializedName("description") val description: String,
                   @ColumnInfo(name = COLUMN_URL) @SerializedName("url") val url: String,
                   @ColumnInfo(name = COLUMN_URL_TO_IMAGE) @SerializedName("urlToImage") val imageUrl: String,
                   @ColumnInfo(name = COLUMN_PUBLISHED_AT) @SerializedName("publishedAt") val publishedAt: String,
                   @ColumnInfo(name = COLUMN_CONTENT) @SerializedName("content") val content: String?,
                   @ColumnInfo(name = COLUMN_CATEGORY) var category: Int) {

    companion object Contract {
        const val TABLE_NAME = "Article"

        const val COLUMN_AUTHOR = "author"
        const val COLUMN_TITLE = "title"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_URL = "url"
        const val COLUMN_URL_TO_IMAGE = "url_to_image"
        const val COLUMN_PUBLISHED_AT = "published_at"
        const val COLUMN_CONTENT = "content"
        const val COLUMN_CATEGORY = "category"
    }
}
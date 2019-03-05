package com.newsfeeds.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.newsfeeds.R
import com.newsfeeds.home.adapters.NewsHorizontalListAdapter.NewsListViewHolder
import com.newsfeeds.network.models.Article
import kotlinx.android.synthetic.main.news_horizontal_list_item.view.*

class NewsHorizontalListAdapter(private val articleList: List<Article>) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.news_horizontal_list_item, parent, false)
        return NewsListViewHolder(inflatedView)
    }

    override fun getItemCount() = articleList.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.render(articleList[position])
    }


    inner class NewsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun render(article: Article) {
            itemView.news_title.text = article.title
            Glide.with(itemView.context)
                    .load(article.imageUrl)
                    .placeholder(R.drawable.placeholder)
                    .into(itemView.banner);
        }

    }
}
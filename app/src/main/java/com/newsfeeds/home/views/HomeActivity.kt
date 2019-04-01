package com.newsfeeds.home.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.newsfeeds.R
import com.newsfeeds.home.adapters.NewsHorizontalListAdapter
import com.newsfeeds.home.contract.HomeActivityContract
import com.newsfeeds.home.itemdecorator.HorizontalDividerItemDecorator
import com.newsfeeds.home.presenter.HomePresenter
import com.newsfeeds.network.models.Article
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeActivityContract {

    private val presenter by lazy {
        HomePresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifecycle.addObserver(presenter)
    }

    override fun renderHeadlinesForBusiness(articleList: List<Article>) {
        val listAdapter = NewsHorizontalListAdapter(articleList)
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        business_news_list.adapter = listAdapter
        business_news_list.layoutManager = layoutManager
        business_news_list.addItemDecoration(HorizontalDividerItemDecorator())
    }

    override fun showBussinessNewsProgressBar() {
        business_news_progress_bar.visibility = View.VISIBLE
    }

    override fun hideBusinessNewsProgressBar() {
        business_news_progress_bar.visibility = View.GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(presenter)
    }

}

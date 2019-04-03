package com.newsfeeds.home.presenter

import android.content.Context
import androidx.lifecycle.*
import com.newsfeeds.home.contract.HomeActivityContract
import com.newsfeeds.home.repositories.HomeRepository
import com.newsfeeds.home.views.HomeActivity
import com.newsfeeds.network.models.Article
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class HomePresenter(private val view: HomeActivityContract, private val context: Context, private val homeActivity: HomeActivity) : LifecycleObserver {

    private var homeRepository = HomeRepository(context)
    private lateinit var businessHeadlinesList: LiveData<List<Article>>

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onRender() {

        businessHeadlinesList = homeRepository.fetchHeadlinesForBusinessFromDB()
        setObserver()
    }

    private fun setObserver() {
        businessHeadlinesList.observe(homeActivity, Observer<List<Article>> {
            if (!it.isEmpty()) {
                view.hideBusinessNewsProgressBar()
                view.renderHeadlinesForBusiness(it)
            }
        })
    }

}
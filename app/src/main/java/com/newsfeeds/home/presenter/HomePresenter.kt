package com.newsfeeds.home.presenter

import com.newsfeeds.home.repositories.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class HomePresenter() {

    fun initialize() {
        val disposable = HomeRepository().fetchHeadlinesForBusiness()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {})
    }


}
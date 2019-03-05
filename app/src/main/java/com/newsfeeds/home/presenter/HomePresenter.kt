package com.newsfeeds.home.presenter

import com.newsfeeds.home.contract.HomeActivityContract
import com.newsfeeds.home.repositories.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class HomePresenter() {

    fun initialize(view: HomeActivityContract) {
        val disposable = HomeRepository().fetchHeadlinesForBusiness()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{
                    view.showBussinessNewsProgressBar()
                }.doOnEvent { _, _ ->
                    view.hideBusinessNewsProgressBar()
                }
                .subscribe({
                    view.renderHeadlinesForBusiness(it.articleList)
                }, {})
    }


}
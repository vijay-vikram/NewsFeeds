package com.newsfeeds.home.presenter

import android.content.Context
import android.util.Log
import com.newsfeeds.home.contract.HomeActivityContract
import com.newsfeeds.home.repositories.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers

class HomePresenter(private val view: HomeActivityContract, private val context: Context) {

    fun initialize() {
        val disposable = HomeRepository(context).fetchHeadlinesForBusiness()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    view.showBussinessNewsProgressBar()
                }.doOnEvent { _, _ ->
                    view.hideBusinessNewsProgressBar()
                }
                .subscribe({
                    view.renderHeadlinesForBusiness(it)
                }, {
                })
    }


}
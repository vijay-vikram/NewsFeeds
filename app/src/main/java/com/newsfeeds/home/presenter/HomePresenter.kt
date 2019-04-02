package com.newsfeeds.home.presenter

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.newsfeeds.home.contract.HomeActivityContract
import com.newsfeeds.home.repositories.HomeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class HomePresenter(private val view: HomeActivityContract, private val context: Context) : LifecycleObserver {

    private var disposable: Disposable? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        disposable = HomeRepository(context).fetchHeadlinesForBusiness()
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

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposable?.dispose()
    }

}
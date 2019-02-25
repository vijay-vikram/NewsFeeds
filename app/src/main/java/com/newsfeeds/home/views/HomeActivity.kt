package com.newsfeeds.home.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newsfeeds.R
import com.newsfeeds.home.presenter.HomePresenter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        HomePresenter().initialize()

    }

}

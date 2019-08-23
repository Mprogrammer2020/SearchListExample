package com.netsetdemoproject.ui.Splash


import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.netsetdemoproject.R
import com.netsetdemoproject.ui.base.BaseActivity
import com.netsetdemoproject.ui.home.SearchActivity


class Splash : BaseActivity(),Runnable {

    var TIME_DURATION = 3000

    override fun run() {

        startActivityWithFinish(SearchActivity::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(this, TIME_DURATION.toLong())

    }

}

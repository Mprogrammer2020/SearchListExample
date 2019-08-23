package com.netsetdemoproject.ui.base

import com.arellomobile.mvp.MvpView

interface BaseView :MvpView {

    fun showLoading()

    fun hideLoading()

    fun showToast(message :String)

    fun  ResponseError(e: Throwable)

}
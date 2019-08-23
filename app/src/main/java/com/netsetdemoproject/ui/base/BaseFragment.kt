package com.netsetdemoproject.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment

class BaseFragment : MvpAppCompatFragment() ,BaseView{


    private var mRootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return mRootView!!
    }

    fun getBaseActivity(): BaseActivity {

        val activity = getActivity()

        if (activity != null && activity is BaseActivity) {

            return activity
        }
        throw RuntimeException("BaseActivity is null")
    }

    override fun showLoading() {
        getBaseActivity().showLoading()
    }

    override fun hideLoading() {
        getBaseActivity().hideLoading()
    }

    override fun showToast(message :String) {
        getBaseActivity().showToast(message)
    }


    override fun ResponseError(e: Throwable) {
        getBaseActivity().ResponseError(e)
    }


}
